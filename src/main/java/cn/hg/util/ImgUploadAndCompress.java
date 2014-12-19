package cn.hg.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.JPEGCodec;


import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;

@SuppressWarnings("restriction")
public class ImgUploadAndCompress 
{

	private File file=null;//文件对象
	private String outputDir;//输出路径
	private String outputFileName;//输出文件名称
	private int outputWidth=100;//默认输出文件宽
	private int outputHeight=100;//默认输出文件高
	private boolean proportion = true;//是否等比缩放
	private String syspath = "";
	
	public void setWidthAndHeight(int width, int height)
	{
		this.outputWidth = width;
		this.outputHeight = height;
	}

	/*
	 * 获得图片大小
	 */
	public long getPicSize(String path)
	{
		 file = new File(path);
		return file.length();
	}
	
	public String compressPic(File file)
	{
		try
		{
				//获得源文件
//				file = new File(inputDir+inputFileName);
				if(!file.exists())
				{
					System.out.println("File not exists!");
					return "";
				}
					Image img = ImageIO.read(file);
					//判断图片格式是否正确?
					if(img.getWidth(null)==-1)
					{
						System.out.println("can not read! ");
						return "no";
					}else
					{
						int newWidth,newHeight;
						//判断是否等比缩放
						if(this.proportion)
						{
							//计算缩放比例
							double rate1=img.getWidth(null)/outputWidth+0.1;
							double rate2=img.getHeight(null)/outputHeight+0.1;
							double rate=rate1>rate2?rate1:rate2;
							newWidth=(int)(img.getWidth(null)/rate);
							newHeight=(int)(img.getHeight(null)/rate);
						}else
						{
							newWidth=outputWidth;
							newHeight=outputHeight;
						}
						BufferedImage tag = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
						/*
						 * Image.SCALE_SMOOTH压缩算法
						 */
						tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH)	, 0, 0, null);
						FileOutputStream out = new FileOutputStream(outputDir+outputFileName);
						 JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);   
						 encoder.encode(tag);   
						  out.close();   
					}
					
		} catch (IOException e) 
		{
		  e.printStackTrace();
		}
		return "ok";
	}
	
	public String compressPic(String outputDir, String outputFileName,File file)
	{
		// 输出图路径
		this.outputDir = outputDir;
		// 输出图文件名
		this.outputFileName = outputFileName;
		return compressPic(file);
	}

	public String compressPic(String outputDir,String outputFileName, int width, int height,boolean gp,File file)
	{
		// 输出图路径
		this.outputDir = outputDir;
		// 输出图文件名
		this.outputFileName = outputFileName;
		// 设置图片长宽
		setWidthAndHeight(width, height);
		// 是否是等比缩放 标记
		this.proportion = gp;
		return compressPic(file);
	}
	
	/**
	 * 
	 * @param file 上传图片文件
	 * @param type 图片类型
	 * @param width 预设图片宽度
	 * @param height 预设图片高度
	 * @param isCompress 是否压缩 
	 * @return 上传图片路径
	 */
	public String dealWithImg(File file ,String type,int width,int height,boolean isCompress,String syspath )
	{
		ImgUploadAndCompress mypic = new ImgUploadAndCompress();
		String ptype = file.getName().substring(file.getName().lastIndexOf("."));
		String outputDir = null ;
		switch (type) {
		case "case":
			outputDir=syspath+ResourcesUtil.getSystemValue("img.upload.case");
			break;
		case "strength":
			outputDir=syspath+ResourcesUtil.getSystemValue("img.upload.strength");
			break; 
		default:
			break;
		}
		String outputName = type + String.valueOf(System.currentTimeMillis());
		mypic.compressPic(outputDir,outputName+ptype,width,height,isCompress,file);  
		return (outputDir+outputName+ptype).replace(syspath, "");
	}
 } 
