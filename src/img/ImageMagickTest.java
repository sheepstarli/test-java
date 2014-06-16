package img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;


public class ImageMagickTest {
	
	private static final String imageMagickPath = "D:\\Tools\\ImageMagick-6.8.7-Q8;D:\\Tools\\GraphicsMagick-1.3.19-Q8";

	public static void main(String[] args) {
		try {
			File file = new File("D:\\image\\720X1280.jpg");
			lowQuality(file.getCanonicalPath(), "D:\\image\\720X1280_1.jpg", 75);
			resizeAndCrop(480, 960, "D:\\image\\720X1280_1.jpg", "D:\\image\\720X1280_2.jpg");
//			File file = new File("D:\\image\\222.png");
//			File file = new File("D:\\image\\47802.jpg");
//			File file = new File("D:\\image\\333.jpg");
//			File file = new File("D:\\image\\444.jpg");
//			if (file.exists()) {
//				System.out.println("图片存在");
//				System.out.println(file.getCanonicalPath());
//				Integer[] size = getSize(file);
//				getImageThumb(size[0], size[1], file.getCanonicalPath(), "D:\\image\\222_thumb.png");
//				getImageThumb(size[0], size[1], file.getCanonicalPath(), "D:\\image\\111_thumb_60_60_middle_quality.jpg");
//				resize(800, 600, file.getCanonicalPath(), "D:\\image\\111_resize.jpg");
//				resize(size[0], size[1], 320, 240, file.getCanonicalPath(), "D:\\image\\222_320_240_2.png");
//				resize(size[0], size[1], 500, 2000, file.getCanonicalPath(), "D:\\image\\111_500_2000_1.jpg");
				

				//540 960
//				resize(size[0], size[1], 540, 540, file.getCanonicalPath(), "D:\\image\\222_540_540.png");
//				resize(size[0], size[1], 540, 800, file.getCanonicalPath(), "D:\\image\\222_540_800.png");
//				resize(size[0], size[1], 540, 320, file.getCanonicalPath(), "D:\\image\\222_540_320.png");
//				resize(size[0], size[1], 240, 960, file.getCanonicalPath(), "D:\\image\\222_240_960.png");
				
				//2440 900
//				resize(size[0], size[1], 2440, 200, file.getCanonicalPath(), "D:\\image\\111_2440_200.jpg");
//				resize(size[0], size[1], 1220, 900, file.getCanonicalPath(), "D:\\image\\111_1220_900.jpg");
//				resize(size[0], size[1], 800, 600, file.getCanonicalPath(), "D:\\image\\111_800_600.jpg");
				

				//1024 768
//				resize(size[0], size[1], 1024, 200, file.getCanonicalPath(), "D:\\image\\47802_1024_200.jpg");
//				resize(size[0], size[1], 800, 600, file.getCanonicalPath(), "D:\\image\\47802_800_600.jpg");
//				resize(size[0], size[1], 800, 500, file.getCanonicalPath(), "D:\\image\\47802_800_500.jpg");
//				resize(size[0], size[1], 800, 700, file.getCanonicalPath(), "D:\\image\\47802_800_700.jpg");
//				resize(size[0], size[1], 600, 700, file.getCanonicalPath(), "D:\\image\\47802_600_700.jpg");
//				resize(size[0], size[1], 500, 700, file.getCanonicalPath(), "D:\\image\\47802_500_700.jpg");
//				resize(size[0], size[1], 400, 700, file.getCanonicalPath(), "D:\\image\\47802_400_700.jpg");
//				resize(size[0], size[1], 300, 700, file.getCanonicalPath(), "D:\\image\\47802_300_700.jpg");
//				resize(size[0], size[1], 200, 500, file.getCanonicalPath(), "D:\\image\\47802_200_500.jpg");
//				resize(size[0], size[1], 100, 600, file.getCanonicalPath(), "D:\\image\\47802_100_600.jpg");
//				resize(size[0], size[1], 320, 200, file.getCanonicalPath(), "D:\\image\\47802_320_200.jpg");;
//				resize(size[0], size[1], 100, 500, file.getCanonicalPath(), "D:\\image\\47802_100_500.jpg");;
//				resize(size[0], size[1], 320, 640, file.getCanonicalPath(), "D:\\image\\47802_320_640.jpg");
				
				//320 200
//				resize(size[0], size[1], 320, 320, file.getCanonicalPath(), "D:\\image\\333_320_320.jpg");
//				resize(size[0], size[1], 320, 640, file.getCanonicalPath(), "D:\\image\\333_320_640.jpg");
//				resize(size[0], size[1], 320, 1640, file.getCanonicalPath(), "D:\\image\\333_320_1640.jpg");
//				resize(size[0], size[1], 640, 1640, file.getCanonicalPath(), "D:\\image\\333_640_1640.jpg");
//				resize(size[0], size[1], 2000, 2000, file.getCanonicalPath(), "D:\\image\\333_2000_2000.jpg");
//				resize(size[0], size[1], 2000, 3000, file.getCanonicalPath(), "D:\\image\\333_2000_3000.jpg");
//				resize(size[0], size[1], 3000, 2000, file.getCanonicalPath(), "D:\\image\\333_3000_2000.jpg");
//				resize(size[0], size[1], 3000, 100, file.getCanonicalPath(), "D:\\image\\333_3000_100.jpg");
				
				//640_1136
//				resize(size[0], size[1], 2000, 2000, file.getCanonicalPath(), "D:\\image\\444_2000_2000.jpg");
//				resize(size[0], size[1], 3000, 2000, file.getCanonicalPath(), "D:\\image\\444_3000_2000.jpg");
//				resize(size[0], size[1], 1000, 2000, file.getCanonicalPath(), "D:\\image\\444_1000_2000.jpg");
//			} else {
//				System.out.println("图片不存在");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getImageThumb(Integer width, Integer height, String srcPath, String newPath) throws Exception {
		Integer destWidth = 0;
		Integer destHeight = 0;
		Integer x = 0;
		Integer y = 0;
		Integer type = -1;
		if (width > height) {
			destWidth = height;
			destHeight = height;
			type = 0;
		} else if (width < height) {
			destWidth = width;
			destHeight = width;
			type = 1;
		}
		if (type == 0) {
			x = (width - destWidth) / 2;
			y = 0;
		} else if (type == 1) {
			x = 0;
			y = (height - destHeight) / 2;
		}
		IMOperation op = new IMOperation();
		op.addImage(srcPath);
		op.crop(destWidth, destHeight, x, y);
		op.addRawArgs("-quality", "75");
		op.resize(60, 60);
		op.addImage(newPath);
		ConvertCmd convert = new ConvertCmd(true);
		convert.setSearchPath(imageMagickPath);
		convert.run(op);
	}
	
	public static Integer[] getSize(File file) throws IOException {
		BufferedImage bi = ImageIO.read(file);
		return new Integer[] {bi.getWidth(), bi.getHeight()};
	}
	
	public static void resize(Integer width, Integer height, Integer destWidth, Integer destHeight, String srcPath, String newPath) throws Exception {
		IMOperation op = new IMOperation();
		op.addImage(srcPath);
		Integer x = 0;
		Integer y = 0;
		
		double source = (double) height / width;
		double dest = (double) destHeight / destWidth;
		if (destWidth > width || destHeight > height) {
			System.out.println("目标比原图大");
			if (source > dest) {
				y = destWidth * height / width;
				op.resize(destWidth, y);
				y = (y - destHeight) / 2;
			} else {
				x = destHeight * width / height;
				op.resize(x, destHeight);
				x = (x - destWidth) / 2;
			}
		} else {
			System.out.println("目标比原图小");
			if (source > dest) {
				op.resize(destWidth, null);
				y = destWidth * height / width;
				y = (y - destHeight) / 2;
			} else {
				op.resize(null, destHeight);
				x = destHeight * width / height;
				x = (x - destWidth) / 2;
			}
		}
		
		op.crop(destWidth, destHeight, x, y);
		op.addRawArgs("-quality", "75");
		op.addImage(newPath);
		ConvertCmd convert = new ConvertCmd(true);
		convert.setSearchPath(imageMagickPath);
		convert.run(op);
	}
	
	public static void lowQuality(String srcPath, String newPath, Integer quality) throws IOException, InterruptedException, IM4JavaException {
		IMOperation op = new IMOperation();
		op.addImage(srcPath);
		op.addRawArgs("-quality", quality.toString());
//		op.addRawArgs("-density", "1x1");
		op.addImage(newPath);
		ConvertCmd convert = new ConvertCmd(true);
		convert.setSearchPath(imageMagickPath);
		convert.run(op);
	}
	
	public static void resizeAndCrop(Integer destWidth, Integer destHeight, String srcPath, String newPath) throws Exception {
		Integer[] size = getSize(new File(srcPath));
		Integer width = size[0];
		Integer height = size[1];
		IMOperation op = new IMOperation();
		op.addImage(srcPath);
		Integer x = 0;
		Integer y = 0;
		
		double source = (double) height / width;
		double dest = (double) destHeight / destWidth;
		if (destWidth > width || destHeight > height) {
			if (source > dest) {
				y = destWidth * height / width;
				op.resize(destWidth, y);
				y = (y - destHeight) / 2;
			} else {
				x = destHeight * width / height;
				op.resize(x, destHeight);
				x = (x - destWidth) / 2;
			}
		} else {
			if (source > dest) {
				op.resize(destWidth, null);
				y = destWidth * height / width;
				y = (y - destHeight) / 2;
			} else {
				op.resize(null, destHeight);
				x = destHeight * width / height;
				x = (x - destWidth) / 2;
			}
		}
		
		op.crop(destWidth, destHeight, x, y);
//		op.addRawArgs("-quality", "50");
//		op.addRawArgs("-density", "1x1");
		op.addImage(newPath);
		ConvertCmd convert = new ConvertCmd(true);
		convert.run(op);
	}

}
