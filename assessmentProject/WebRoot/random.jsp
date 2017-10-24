<%@ page language="java"
	import="java.util.*,java.io.*,java.awt.*,java.awt.image.*"
	pageEncoding="utf-8"%>
<%@page import="javax.imageio.ImageIO"%>

		<%!//随机数生成器，用于产生随机数
			private Random random = new Random();
		
			//设定图片的宽度和高度
			private int width = 120;
			private int height = 30;
			
		%>

		<%!
			private Color getRandomColor(int bound) {
				int r = random.nextInt(bound);
				int g = random.nextInt(bound);
				int b = random.nextInt(bound);
				return new Color(r, g, b);
			}
		
			public String getRandomString() {
				//字符串种子，将从该字符串中获得随机字符。因为o和0,l和1很难区分,所以,去掉大小写的o和l
				final String SEED = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";
				StringBuffer sb = new StringBuffer("");
				for (int i = 0; i < 4; i++) {
					sb.append(SEED.charAt(random.nextInt(SEED.length())));
				}
				return sb.toString();
			}
	
		%>

	
		<%
			
			//指定响应的内容内型
			response.setContentType("image/jpeg");
			//禁止图像缓存。
			response.setHeader("pragma", "no-cache");
			response.setHeader("cache-control", "no-cache");
			response.setDateHeader("expires", 0);

			
			
		   
			
			
			
			//在内存中创建图像对象
			BufferedImage bufImg = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			//获得图像对象的画笔
			Graphics2D g = (Graphics2D) (bufImg.getGraphics());

			//将图像填充成白色背景色
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, width, height);
			//绘制图像的黑色边框
			g.setColor(Color.BLACK);

			g.drawRect(0, 0, width - 1, height - 1);

			//随机产生干扰点,并用不同的颜色表示，使图象中的认证码不易被其它程序探测到
			for (int i = 0; i < 200; i++) {
				//随机生成干扰点的坐标
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				g.setColor(getRandomColor(200)); //设置干扰点的颜色，随机生成
				g.drawOval(x, y, 0, 0); //画干扰点
			}

			String strValidate = this.getRandomString(); //生成验证字符串
			g.setFont(new Font("Tahoma", Font.BOLD, 18)); //设置字体
			//画认证码,每个认证码在不同的水平位置
			String[] strAry = new String[4];
			//将验证字符串的文字逐个画到图像中
			for (int i = 0; i < strAry.length; i++) {
				strAry[i] = strValidate.substring(i, i + 1);
				int w = 0;
				int x = (i + 1) % 3;
				//随机生成验证码字符的水平偏移量
				if (x == random.nextInt(3)) {
					w = 19 - random.nextInt(7);
				} else {
					w = 19 + random.nextInt(7);
				}
				//随机生成字体颜色
				g.setColor(this.getRandomColor(225));
				g.drawString(strAry[i], 30 * i + 10, w); //在图像中画文字

			}

			//画干扰线
			for (int i = 0; i < 5; i++) {
				//随机生成干扰线的起始和终止坐标
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xx = random.nextInt(width);
				int yy = random.nextInt(height);
				g.setColor(getRandomColor(180));
				g.drawLine(x, y, xx, yy); //画干扰线
			}
			
			
			try {
				g.dispose();
				ImageIO.write(bufImg, "JPEG",response.getOutputStream()); //将生成的图片写入到指定的输出流中

			} catch (Exception ioe) {

			}
			out.clear();
			out = pageContext.pushBody();
			
			session.setAttribute("validateCode", strValidate); //将验证字符串保存到session中
		

		%>

