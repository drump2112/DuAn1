/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.background;

import com.twelvemonkeys.image.ImageUtil;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import swing.fbr.FancyBorderRadius;
import swing.shadow.ShadowRenderer;

/**
 *
 * @author sethk
 */
public class Background extends JComponent {

    private boolean showPaint;

    public boolean isShowPaint() {
        return showPaint;
    }

    public void setShowPaint(boolean showPaint) {
        this.showPaint = showPaint;
    }
    private float animate;
    private Icon image;
    private BufferedImage bufferedImage;
    private Component blur;

    public Component getBlur() {
        return blur;
    }

    public void setBlur(Component blur) {
        this.blur = blur;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createImage();
                repaint();
            }
        });
    }

    public Background() {
        image = new ImageIcon(getClass().getResource("/swing/background/bg2.jpg"));
    }

    private void createImage() {
        if (image != null) {
            int width = getWidth();
            int height = getHeight();

            if (width > 0 && height > 0) {
                bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = bufferedImage.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                Rectangle rec = getAutoSize(image);
                g2.drawImage(((ImageIcon) image).getImage(), rec.x, rec.y, rec.width, rec.height, null);
                if (blur != null) {
                    createBlurImage(g2);
                }
                g2.dispose();
            }
        }
    }

    private void createBlurImage(Graphics2D g) {
        int x = blur.getX();
        int y = blur.getY();
        int width = blur.getWidth();
        int height = blur.getHeight();
        int shadow = 8;
        if (width > 0 && height > 0) {
            
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape shape = new FancyBorderRadius(width, height, "91% 9% 92% 8% / 12% 83% 17% 88% ").getShape();
            g2.fill(shape);
            g2.setComposite(AlphaComposite.SrcIn);
            g2.drawImage(ImageUtil.blur(bufferedImage.getSubimage(x, y, width, height), 10f), 0, 0, null);
            g2.setColor(new Color(255, 255, 255, 10));
            g2.dispose();
            g.drawImage(new ShadowRenderer(shadow, 0.3f, new Color(0, 0, 0)).createShadow(img), (int) (x - shadow * 0.8f), (int) (y - shadow * 0.8f), null);
            g.drawImage(img, x, y, null);
            
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (bufferedImage != null) {
            BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
            g2.setComposite(AlphaComposite.SrcIn);
            g2.drawImage(bufferedImage, 0, 0, null);
            g2.dispose();
            grphcs.drawImage(img, 0, 0, null);
        }
        super.paintComponent(grphcs);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createImage();
                repaint();
            }
        });

    }

    

    private Rectangle getAutoSize(Icon image) {
        int w = getWidth();
        int h = getHeight();
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        int x = (w - width) / 2;
        int y = (h - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    public void setAlpha(float fraction) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public float getAnimate() {
        return animate;
    }

    public void setAnimate(float animate) {
        this.animate = animate;
        repaint();
    }

}
