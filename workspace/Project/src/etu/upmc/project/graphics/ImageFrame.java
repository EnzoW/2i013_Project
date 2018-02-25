package etu.upmc.project.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageFrame extends JPanel implements Runnable 
{
	private static final int REFRESH_DELAY = 10;
	
	private BufferedImage image;

	public ImageFrame() 
	{
		super();
		new Thread(this).start();
	}

	public void setImage( BufferedImage __image)
	{
		this.image = __image;
	}

	public void paintComponent(Graphics g) 
	{
		g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	public void run() 
	{
		for (;;)
		{
			repaint();
			try {
				Thread.sleep(ImageFrame.REFRESH_DELAY);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

	static public ImageFrame makeFrame (String name, BufferedImage image, int width, int height )
	{
		ImageFrame imageFrame = new ImageFrame();
		JFrame frame = new JFrame(name);

		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(imageFrame);
		frame.setVisible(true);

		imageFrame.setImage(image);

		return imageFrame;
	}
}
