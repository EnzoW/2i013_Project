package etu.upmc.project.graphics;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.fixedfunc.GLMatrixFunc;

import com.jogamp.opengl.util.Animator;

import etu.upmc.project.World;
import etu.upmc.project.events.Event;
import etu.upmc.project.events.EventInit;
import etu.upmc.project.events.EventUpdate;
import etu.upmc.project.graphics.objects.Agent;
import etu.upmc.project.graphics.objects.Tree;

public class Displayer3D implements GLEventListener, KeyListener, MouseListener, Observer {

	private static GLCapabilities CAPS;  // GO FAST ???

	private static boolean MY_LIGHT_RENDERING = false; // true: nicer but slower
	private static boolean VIEW_FROM_ABOVE = false; // also deactivate altitudes
	private static Animator animator; 

	private float rotateX = 0.0f;
	private float rotationVelocity = 0.0f; // 0.2f

	float heightFactor; //64.0f; // was: 32.0f;
	double heightBooster; // applied to landscape values. increase heights.

	float offset;
	float stepX;
	float stepY;
	float lenX;
	float lenY;

	float smoothFactor[];
	int smoothingDistanceThreshold;

	private float colors[][][];
	private double maxEverHeightValue;
	private double minEverHeightValue;
	private int[][] cellsStates;
	private int width;
	private int height;
	private double[][] elevation; 

	public Displayer3D ()
	{

	}

	private void init()
	{
		this.colors = new float[this.width][this.height][3];
		this.cellsStates = new int[this.width][this.height];

		System.out.println("Landscape contains " + this.width*this.height + " tiles. (" + this.width + "x" + this.height +")");

		for (int x = 0; x < this.width - 1; x++)
		{
			for (int y = 0; y < this.height - 1; y++)
			{
				double minHeightValue = Math.min(Math.min(elevation[x][y],elevation[x+1][y]),Math.min(elevation[x][y+1],elevation[x+1][y+1]));
				double maxHeightValue = Math.max(Math.max(elevation[x][y],elevation[x+1][y]),Math.max(elevation[x][y+1],elevation[x+1][y+1])); 

				if ( this.maxEverHeightValue < maxHeightValue )
					this.maxEverHeightValue = maxHeightValue;
				if ( this.minEverHeightValue > minHeightValue )
					this.minEverHeightValue = minHeightValue;
			}
		}

		for ( int x = 0 ; x < this.width ; x++ )
		{
			for ( int y = 0 ; y < this.height ; y++ )
			{
				float height = (float) this.elevation[x][y];

				if ( height >= 0 )
				{
					this.colors[x][y][0] = height / ((float) this.maxEverHeightValue);
					this.colors[x][y][1] = 0.9f + 0.1f * height / ((float) this.maxEverHeightValue);
					this.colors[x][y][2] = height / ((float) this.maxEverHeightValue);
				}
				else
				{
					// water
					this.colors[x][y][0] = -height;
					this.colors[x][y][1] = -height;
					this.colors[x][y][2] = 1.f;
				}
			}
		}

		heightFactor = 32.0f; //64.0f; // was: 32.0f;
		heightBooster = 6.0; // default: 2.0 // 6.0 makes nice high mountains.

		offset = -200.0f; // was: -40.
		stepX = (-offset*2.0f) / this.width;
		stepY = (-offset*2.0f) / this.width;
		lenX = stepX / 2f;
		lenY = stepY / 2f;

		smoothFactor = new float[4];
		for ( int i = 0 ; i < 4 ; i++ )
			smoothFactor[i] = 1.0f;

		smoothingDistanceThreshold = 30; //30;

	}

	/**
	 * 
	 */
	public void run()
	{
		CAPS = new GLCapabilities(null); //!n
		CAPS.setDoubleBuffered(true);  //!n

		final GLCanvas canvas = new GLCanvas(CAPS); // original

		final Frame frame = new Frame("Project");
		animator = new Animator(canvas);
		canvas.addGLEventListener(this);
		canvas.addMouseListener(this);// register mouse callback functions
		canvas.addKeyListener(this);// register keyboard callback functions
		frame.add(canvas);
		frame.setSize(1024, 768);
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				animator.stop();
				frame.dispose();
				System.exit(0);
			}
		});
		frame.setVisible(true);
		animator.setRunAsFastAsPossible(true); // GO FAST!  --- DOES It WORK? 
		animator.start();
		canvas.requestFocus();
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		if (!(o instanceof World) || !(arg instanceof Event))
		{
			throw new IllegalArgumentException(this.getClass().getName() + " : only an instance of the class \"World\" can be observable by " 
					+ this.getClass().getSimpleName() + ".");
		}

		if (arg instanceof EventInit)
		{
			EventInit event = (EventInit) arg;
			this.width = event.getWidth();
			this.height = event.getHeight();
			this.elevation = event.getElevation();
			this.init();
			this.run();
		}
		else if (arg instanceof EventUpdate)
		{
			for (int i = 0; i < this.cellsStates.length; i++)
			{
				this.cellsStates[i] = ((EventUpdate) arg).getBuffer()[i].clone();
			}
		}
	}


	@Override
	public void init(GLAutoDrawable glDrawable) {
		GL2 gl = glDrawable.getGL().getGL2();

		gl.glEnable(GL2.GL_DOUBLEBUFFER);
		glDrawable.setAutoSwapBufferMode(true);

		gl.glShadeModel(GLLightingFunc.GL_SMOOTH);
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glClearDepth(1.0f);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glDepthFunc(GL.GL_LEQUAL);
		gl.glHint(GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);

		// Culling - display only triangles facing the screen
		gl.glCullFace(GL.GL_FRONT);
		gl.glEnable(GL.GL_CULL_FACE);
		gl.glEnable(GL.GL_DITHER);
	}


	@Override
	public void display(GLAutoDrawable gLDrawable) {

		// ** clean screen

		final GL2 gl = gLDrawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();

		// ** render all

		// *** ADD LIGHT

		if ( MY_LIGHT_RENDERING )
		{
			// Prepare light parameters.
			float SHINE_ALL_DIRECTIONS = 1;
			float[] lightPos = {40.f, 0.f, -300.f, SHINE_ALL_DIRECTIONS};
			float[] lightColorAmbient = {0.2f, 0.2f, 0.2f, 1f};
			float[] lightColorSpecular = {0.8f, 0.8f, 0.8f, 1f};

			// Set light parameters.
			gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_POSITION, lightPos, 0);
			gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_AMBIENT, lightColorAmbient, 0);
			gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_SPECULAR, lightColorSpecular, 0);

			// Enable lighting in GL.
			gl.glEnable(GL2.GL_LIGHT1);
			gl.glEnable(GL2.GL_LIGHTING);
		}


		if ( VIEW_FROM_ABOVE == true )
		{
			// as seen from above, no rotation (debug mode)
			gl.glTranslatef(0.0f, 0.0f, -500.0f); // 0,0,-5
		}
		else
		{
			// continuous rotation (default view) 
			gl.glTranslatef(0.0f, -44.0f, -130.0f); // 0,0,-5
			gl.glRotatef(rotateX, 0.0f, 1.0f, 0.0f);
			gl.glRotatef(-90.f, 1.0f, 0.0f, 0.0f);
		}

		// ** draw everything
		gl.glBegin(GL2.GL_QUADS);                

		for ( int x = 0 ; x < this.width-1 ; x++ )
			for ( int y = 0 ; y < this.height-1 ; y++ )
			{
				double height = this.elevation[x][y];
				float normalizeHeight = (smoothFactor[0] + smoothFactor[1] + smoothFactor[2] + smoothFactor[3]) / 4.f * (float)heightBooster * heightFactor;

				if ( height >= 0 )
				{
					this.colors[x][y][0] = (float) (height / this.maxEverHeightValue);
					this.colors[x][y][1] = (float) (0.9f + 0.1f * height / this.maxEverHeightValue);
					this.colors[x][y][2] = (float) (height / this.maxEverHeightValue);
				}
				else
				{
					// water
					this.colors[x][y][0] = (float) -height;
					this.colors[x][y][1] = (float) -height;
					this.colors[x][y][2] = 1.f;
				}
				
				switch (this.cellsStates[x][y])
				{
				case 1:
				case 2:
				case 3:
					Tree.displayObjectAt(gl, this.cellsStates[x][y], x, y, height, offset, stepX, stepY, lenX, lenY, normalizeHeight);
					break;
				case 4:
					this.colors[x][y][0] = 158;
					this.colors[x][y][1] = 157;
					this.colors[x][y][2] = 36;
					break;
				case 5:
				case 6:
					Agent.displayObjectAt(gl, this.cellsStates[x][y], x, y, height, offset, stepX, stepY, lenX, lenY, normalizeHeight);
					break;
				}

				gl.glColor3f(this.colors[x][y][0], this.colors[x][y][1], this.colors[x][y][2]);

				// * if light is on
				if (MY_LIGHT_RENDERING)
				{
					gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_AMBIENT, this.colors[x][y], 0);
					gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_DIFFUSE, this.colors[x][y], 0);
					gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, this.colors[x][y], 0);
					gl.glMateriali(GL.GL_FRONT_AND_BACK, GL2.GL_SHININESS, 4);
					float[] colorBlack  = {0.0f,0.0f,0.0f,1.0f};
					gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_EMISSION, colorBlack, 0);
				}

				// Border visual smoothing : smooth altitudes near border (i.e. nicer rendering)
				if (VIEW_FROM_ABOVE != true)
				{
					if ( Math.min(Math.min(x, this.width-x-1),Math.min(y, this.height-y-1)) < smoothingDistanceThreshold )
					{

						for ( int i = 0 ; i < 4 ; i++ )
						{
							int xIt = i==1||i==2?1:0;
							int yIt = i==0||i==1?1:0;
							smoothFactor[i] = (float)
									Math.min(
											Math.min( 1.0 , (double)Math.min(x+xIt,this.width-x+xIt)/(double)smoothingDistanceThreshold ) ,  // check x-axis
											Math.min( 1.0 , (double)Math.min(y+yIt,this.height-y+yIt)/(double)smoothingDistanceThreshold )    // check y-axis
											);
						}	                            	
					}
					else
					{
						for ( int i = 0 ; i < 4 ; i++ )
							smoothFactor[i] = 1.0f;
					}
				}

				for ( int i = 0 ; i < 4 ; i++ )
				{
					int xIt = i==1||i==2?1:0;
					int yIt = i==0||i==1?1:0;
					float xSign = i==1||i==2?1.f:-1.f;
					float ySign = i==0||i==1?1.f:-1.f;

					float zValue = 0.f;

					if ( VIEW_FROM_ABOVE == false )
					{
						double altitude = elevation[(x + xIt) % (this.width - 1)][( y + yIt) % (this.height - 1)] * heightBooster;
						if ( altitude < 0 ) 
							zValue = 0;
						else
							zValue = heightFactor*(float)altitude * smoothFactor[i];
					}

					gl.glVertex3f( offset+x*stepX+xSign*lenX, offset+y*stepY+ySign*lenY, zValue);
				}
			}

		gl.glEnd();      		

		rotateX += rotationVelocity; 
	}

	@Override
	public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
		GL2 gl = gLDrawable.getGL().getGL2();
		final float aspect = (float) width / (float) height;
		gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
		gl.glLoadIdentity();
		final float fh = 0.5f;
		final float fw = fh * aspect;
		gl.glFrustumf(-fw, fw, -fh, fh, 1.0f, 1000.0f);
		gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
		gl.glLoadIdentity();
	}


	/**
	 * 
	 */
	@Override
	public void dispose(GLAutoDrawable gLDrawable) {
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mousePressed(MouseEvent mouse)
	{
		/* example from doublebuf.java
		    switch (mouse.getButton()) {
		      case MouseEvent.BUTTON1:
		        spinDelta = 2f;
		        break;
		      case MouseEvent.BUTTON2:
		      case MouseEvent.BUTTON3:
		        spinDelta = 0f;
		        break;
		    }
		    /**/
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void keyPressed(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			new Thread()
			{
				public void run() { animator.stop();}
			}.start();
			System.exit(0);
			break;
		case KeyEvent.VK_V:
			VIEW_FROM_ABOVE = !VIEW_FROM_ABOVE ;
			break;
		case KeyEvent.VK_2:
			heightBooster++;
			break;
		case KeyEvent.VK_1:
			if ( heightBooster > 0 )
				heightBooster--;
			break;
		case KeyEvent.VK_Q:
			rotationVelocity-=0.1;
			break;
		case KeyEvent.VK_D:
			rotationVelocity+=0.1;
			break;
		case KeyEvent.VK_Z:
			break;
		case KeyEvent.VK_S:
			break; 
		case KeyEvent.VK_H:
			System.out.println(
					"Help:\n" +
							"           [v] change view\n" +
							"           [o] objects display on/off\n" +
							"           [1] decrease altitude booster\n" +
							"           [2] increase altitude booster\n" +
							" [cursor keys] navigate in the landscape\n" +
							"         [q/d] rotation wrt landscape\n" +
							" [cursor keys] navigate\n"
					);
			break;
		default:
			break;
		}
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}