package etu.upmc.project.graphics;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import etu.upmc.project.cellularautomaton.CellularAutomaton;
import etu.upmc.project.events.Event;
import etu.upmc.project.events.EventInit;
import etu.upmc.project.events.EventUpdate;
import etu.upmc.project.graphics.objects.Agent;
import etu.upmc.project.graphics.objects.Tree;
import etu.upmc.project.landscape.LandscapeGenerator;
import etu.upmc.project.log.Log;
import etu.upmc.project.tools.Tools;

public class Displayer3D implements GLEventListener, KeyListener, Observer {

	/* ****************************************************************
	 * 	Constants
	 * ****************************************************************/

	public static final float HEIGHT_FACTOR = 32f;

	/* ****************************************************************
	 * 	Private context
	 * ****************************************************************/

	private int width, height;
	/* Data from automaton */
	private int[][] cellsStates, environment;
	private int [][][] informations;
	private double[][] elevation;	
	private double maxEverHeightValue, minEverHeightValue;
	private Object lock;
	/* Data to perform graphical display */
	private Frame frame;
	private float rotateX, rotateY, rotateZ;
	private float translateX, translateY, translateZ;
	private float colors[][][];
	private boolean isDebugMode;
	/* FPS */
	private int it, lastItStamp;
	private long lastTimeStamp;

	/* ****************************************************************
	 * 	Private methods
	 * ****************************************************************/

	private void init()
	{
		this.colors = new float[this.width][this.height][4];
		this.cellsStates = new int[this.width][this.height];
		this.informations = new int[this.width][this.height][3];
		this.lock = new Object();
		this.rotateX = 0.0f;
		this.rotateY = 0.0f;
		this.rotateZ = -90.0f;
		this.translateX = 0;
		this.translateY = -50;
		this.translateZ = -this.height / 2;
		this.isDebugMode = false;
		this.it = 0;
		this.lastItStamp = 0;
		this.lastItStamp = 0;

		Log.info("Landscape contains " + this.width*this.height + " tiles. (" + this.width + "x" + this.height +")");

		for (int x = 0; x < this.width; x++)
		{
			for (int y = 0; y < this.height; y++)
			{
				int x2 = x + 1 >= this.width ? this.width - 1 : x + 1;
				int y2 = y + 1 >= this.height ? this.height - 1 : y + 1;
				double minHeightValue = Math.min(Math.min(elevation[x][y],elevation[x2][y]),Math.min(elevation[x][y2],elevation[x2][y2]));
				double maxHeightValue = Math.max(Math.max(elevation[x][y],elevation[x2][y]),Math.max(elevation[x][y2],elevation[x2][y2])); 

				this.maxEverHeightValue = Math.max(maxHeightValue, this.maxEverHeightValue);
				this.minEverHeightValue = Math.min(minHeightValue, this.minEverHeightValue);
			}
		}
	}

	private void run()
	{
		GLCapabilities glCaps = new GLCapabilities(null);
		GLCanvas canvas = new GLCanvas(glCaps);
		Animator animator = new Animator(canvas);
		this.frame = new Frame("Project");

		glCaps.setDoubleBuffered(true);
		canvas.addGLEventListener(this);
		canvas.addKeyListener(this);
		frame.add(canvas);
		frame.setSize(800, 600);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setResizable(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				animator.stop();
				frame.dispose();
				System.exit(0);
			}
		});
		frame.setVisible(true);
		animator.setRunAsFastAsPossible(true);
		animator.start();
		canvas.requestFocus();
	}

	/* ****************************************************************
	 * 	Events
	 * ****************************************************************/

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
			this.environment = event.getEnvironment();
			this.init();
			this.run();
		}
		else if (arg instanceof EventUpdate)
		{
			synchronized (this.lock) {
				for (int i = 0; i < this.cellsStates.length; i++)
				{
					this.cellsStates[i] = ((EventUpdate) arg).getBuffer()[i].clone();
//					System.arraycopy(this.cellsStates[i], 0, ((EventUpdate) arg).getBuffer()[i], 0, this.cellsStates[i].length);
					for (int j = 0; j < this.informations[i].length; j++)
					{
						this.informations[i][j] = ((EventUpdate) arg).getInformations()[i][j].clone();
//						System.arraycopy(this.informations[i][j], 0, ((EventUpdate) arg).getInformations()[i][j], 0, this.informations[i][j].length);
					}
				}
			}
		}
	}


	/* ****************************************************************
	 * 	OpenGL - Graphic render
	 * ****************************************************************/

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
		// Transparency for water
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
	}


	@Override
	public void display(GLAutoDrawable gLDrawable) {
		if (System.currentTimeMillis() - lastTimeStamp >= 1000)
		{
			int fps = this.it - this.lastItStamp;
			this.lastItStamp = this.it;
			this.lastTimeStamp = System.currentTimeMillis();
			this.frame.setTitle("Project ~ " + fps + " FPS");
		}

		this.it++;

		GL2 gl = gLDrawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();

		if (isDebugMode)
		{
			gl.glTranslatef(0, 0, -this.width - 25);
		}
		else
		{
			gl.glTranslatef(this.translateX, this.translateY, this.translateZ);
			gl.glRotatef(this.rotateX, 0, 1, 0);
			gl.glRotatef(this.rotateY, 0, 0, 1);
			gl.glRotatef(this.rotateZ, 1, 0, 0);
		}

		synchronized (this.lock) {

			// ** draw everything
			gl.glBegin(GL2.GL_QUADS);                

			for (int x = 0 ; x < this.width; x++)
			{
				for (int y = 0 ; y < this.height; y++)
				{
					switch (this.environment[x][y])
					{
					case LandscapeGenerator.ENVIRONMENT_WATER:
						this.colors[x][y][0] = 0;
						this.colors[x][y][1] = 0;
						this.colors[x][y][2] = 0xFF;
						this.colors[x][y][3] = Tools.map((float) -this.elevation[x][y], (float) LandscapeGenerator.WATER_ALTITUDE, (float) -this.minEverHeightValue, 1, 0.25f);
						break;
					case LandscapeGenerator.ENVIRONMENT_SAND:
						this.colors[x][y][0] = 0xEF;
						this.colors[x][y][1] = 0xDD;
						this.colors[x][y][2] = 0x6F;
						this.colors[x][y][3] = 0xFF;
						break;
					case LandscapeGenerator.ENVIRONMENT_VOLCANO:
						//					this.colors[x][y][0] = 0xFF;
						//					this.colors[x][y][1] = 0x00;
						//					this.colors[x][y][2] = 0x00;
						//					this.colors[x][y][3] = 0xFF;
						//					break;
					default:
						this.colors[x][y][0] = (float) (this.elevation[x][y] / this.maxEverHeightValue);
						this.colors[x][y][1] = (float) (0.9f + 0.1f * this.elevation[x][y] / this.maxEverHeightValue);
						this.colors[x][y][2] = (float) (this.elevation[x][y] / this.maxEverHeightValue);
						this.colors[x][y][3] = 0xFF;
						break;
					}

					if (CellularAutomaton.isInStates(this.cellsStates[x][y], CellularAutomaton.FOREST_GRASS))
					{
						this.colors[x][y][0] = 0;
						this.colors[x][y][1] = 0xFF;
						this.colors[x][y][2] = 0;
					}

					if (CellularAutomaton.isInStates(this.cellsStates[x][y], CellularAutomaton.FOREST_TREE, CellularAutomaton.FOREST_TREE_BURNING, CellularAutomaton.FOREST_ASHES))
					{
						Tree.displayObjectAt(gl, this.cellsStates[x][y], x - this.width / 2, y - this.height / 2, (float) this.elevation[x][y], this.informations[x][y][0]);
					}
					else if (CellularAutomaton.isInStates(this.cellsStates[x][y], CellularAutomaton.AGENT_PREY, CellularAutomaton.AGENT_PREDATOR, CellularAutomaton.AGENT_PREY_FLEEING, 
							CellularAutomaton.AGENT_PREDATOR_HUNTING, CellularAutomaton.AGENT_PREY_YOUNGLING, CellularAutomaton.AGENT_PREDATOR_YOUNGLING))
					{
						Agent.displayObjectAt(gl, this.cellsStates[x][y], x - this.width / 2, y - this.height / 2, (float) this.elevation[x][y]);
					}

					gl.glColor4f(this.colors[x][y][0], this.colors[x][y][1], this.colors[x][y][2], this.colors[x][y][3]);

					for ( int i = 0 ; i < 4 ; i++ )
					{
						int xIt = Math.min((i==1 || i == 2 ? 1 : 0) + x, this.width - 1);
						int yIt = Math.min((i==0 || i == 1 ? 1 : 0) + y, this.height - 1);
						float xSign = i == 1 || i == 2 ? 1 : -1;
						float ySign = i == 0 || i == 1 ? 1 : -1;

						float zValue = 0.f;

						if (!isDebugMode)
						{
							double altitude = elevation[xIt][yIt] * HEIGHT_FACTOR;
							if (altitude <= LandscapeGenerator.WATER_ALTITUDE) 
								zValue = 0;
							else
								zValue = (float) (altitude);
						}

						gl.glVertex3f(x + xSign - this.width / 2, y + ySign - this.height / 2, zValue);
					}
				}
			}
			gl.glEnd();
		}
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


	@Override
	public void dispose(GLAutoDrawable gLDrawable) {
	}


	@Override
	public void keyPressed(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_V:
			isDebugMode = !isDebugMode ;
			break;
		case KeyEvent.VK_UP:
			this.translateZ++;
			break;
		case KeyEvent.VK_DOWN:
			this.translateZ--;
			break;
		case KeyEvent.VK_LEFT:
			this.translateX++;
			break;
		case KeyEvent.VK_RIGHT:
			this.translateX--;
			break;
		case KeyEvent.VK_Z:
			this.translateY--;
			break;
		case KeyEvent.VK_S:
			this.translateY++;
			break;
		case KeyEvent.VK_Q:
			rotateX += 2;
			break;
		case KeyEvent.VK_D:
			rotateX -= 2;
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
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}