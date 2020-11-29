import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.awt.geom.Point2D.Float;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TextBox implements Drawable{

    private class TextBoxDialog {
    }


    Color color = Color.BLACK;      //画笔颜色
    float alpha = 1f;       //透明度

    Point2D.Float startPoint;
    TextBox(Point2D.Float p) {
        startPoint = p;
    }
    
    //几乎所有的计算都可以借用矩形
    //filled代表是否填充文字
    String filled = null;


    final int radius = 5;

    @Override
    public void drawOnGraphics2D(Graphics2D g) {
        g.setColor(color);
        if(isFilled()){
            Font f = new Font("SansSerif",Font.BOLD,14);
            var oldFont = g.getFont();
            g.drawString(filled,startPoint.x,startPoint.y);
            g.setFont(oldFont);
        }else{
            g.drawLine((int)startPoint.x,(int)startPoint.y,(int)startPoint.x,(int)startPoint.y+-7);
        }
    }

    @Override 
    public boolean isFilled(){
        return filled!=null; 
    }

    @Override
    public void setFill(){ //弹出一个选框，设置文字，影响字体，字号等
        filled = JOptionPane.showInputDialog(null, "设置文本","Input Here");
    }

    @Override
    public void setFill(Color c){ 
        color=c;
    }

    @Override
    public void setAlpha(float f) {
        
    }

    @Override
    public void setColor(Color c) {
        color=c;
    }

    @Override
    public void setBorder(Color c, BasicStroke s) {

    }

    @Override
    public Color getBorderColor() {
        return color;
    }

    @Override
    public BasicStroke getBasicStroke() {
        return new BasicStroke();
    }

    @Override
    public Color getFillColor() {
        return color;
    }

    @Override
    public void disableFill() {
        setFill();
    }

    @Override
    public void scale(float times) {

    }

    @Override
    public void moveStartTo(Float p) {
        startPoint = p ;
    }

    @Override
    public void moveStartTo(float x, float y) {
        startPoint.setLocation(x, y);
    }

    @Override
    public Float getStart() {
        return startPoint;
    }

    @Override
    public void putEndPoint(Float p) {
        startPoint = p;
    }

    @Override
    public void putEndPoint(float x, float y) {
        startPoint.setLocation(x, y);
    }

    @Override
    public Float getEndPoint() {
        return startPoint;
    }

    @Override
    public boolean pointOn(Float p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean pointOn(float x, float y) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean pointOnFill(Float p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean pointOnFill(float x, float y) {
        // TODO Auto-generated method stub
        return false;
    }

}