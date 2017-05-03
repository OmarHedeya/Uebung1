package jmjrst.main;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.MathContext;
import java.util.Date;
import java.util.Locale;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataController;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;

import org.jis.generator.Generator;
import org.junit.*;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author OmarHedeya
 * Class to perform tests
 */
public class ImageTest {

	Generator test = new Generator(null, 0);
	File filePicture = new File("src\\test\\resources\\picture.jpg");
	BufferedImage image;
	BufferedImage image2;

	@Before
	public void setUp() throws Exception {
		//image = rotate(filePicture);
		try {
		    image = ImageIO.read(filePicture);
		} catch (IOException e) {
		}
	}
	
	@After
	public void tearDown() {
	      Calendar calendar = Calendar.getInstance();
	      //SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	      Date date = new Date();
	      calendar.setTime(date);
	      int hour = calendar.get(Calendar.HOUR);
	      int minute = calendar.get(Calendar.MINUTE);
	      int second = calendar.get(Calendar.SECOND);
		try
		{
	    File outputfile = new File("target//data_test//"+"rotatedPicture_"+hour+""+minute+""+second+"_"+"SSS"+".jpg");
	    if(image2 != null)
	    ImageIO.write(image2, "jpg", outputfile);
		}
	    catch(IOException e) {
	    	
	    	
	    }
	}
	
	
	@Test
	public void testNoChange1() {
		image2 = test.rotateImage(image, 0.0); 
	  assertEquals(image, image2);	//test.rotateImage(image, 0.0)
	}
	
	@Test
	public void testNoChange2() {
		image2 = test.rotateImage(null, 0.0);
		assertEquals(null, image2);

	}
	
	@Test(expected = Exception.class)
	public void testException()
	{
		test.rotateImage(image, 0.7); // Exception should be raised
		//how to assess Exception?
	}
	

	

	
	
	@Test
	public void test90Degrees() {
		image2 = test.rotateImage(image, ((0.5) * Math.PI)); //assess height and width
		//BufferedImage image3 = test.rotateImage(image2, ((0.5)*Math.PI));
		//BufferedImage image4 = test.rotateImage(image3, ((0.5)*Math.PI));
		//BufferedImage image5 = test.rotateImage(image4, ((0.5)*Math.PI));
        //assertEquals (image5, image);
		assertTrue( image2.getHeight() == image.getWidth() && image2.getWidth() == image.getHeight());
	}
	
	
	@Test
	public void test270Degrees() {
		image2 = test.rotateImage(image, ((1.5)* Math.PI ));
		assertTrue(image2.getHeight() == image.getWidth() && image2.getWidth() == image.getHeight());
	}
	
	@Test
	public void test180Degrees() {
		image2 = test.rotateImage(image, (Math.PI));
		//BufferedImage image3 = test.rotateImage(image2, (Math.PI));
		//assertEquals(image, image3);
		assertTrue(image2.getHeight() == image.getHeight() && image2.getWidth() == image.getWidth());
        
	}
	
	
}