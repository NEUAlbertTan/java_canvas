import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Canvas extends JFrame {

    /**
     * 测试用主窗口
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        new Canvas();
    }

    public Canvas() {
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new PaintSurface(new StatesModel() {
            

            public void execute(Command command) {
            }

            public void undo() {
            }

            public void redo() {
            }

            ArrayList<Drawable> a = new ArrayList<Drawable>();

            {
                var r  = new Random();
                a.add(BasicDrawableFactory.makeLine(r.nextInt(200),r.nextInt(200),r.nextInt(200),r.nextInt(200)));
            }

            public ArrayList<Drawable> getAllDrawable() {
                return a;
            }

            public Drawable.TYPE getType() {
                return Drawable.TYPE.PATH;
            }

            public Color getColor() {
                return Color.BLUE;
            }

            public String getStringInput() {
                return "TryString";
            }

            public void setDrawable(ArrayList<Drawable> d) {
                a = d;
            }

            @Override
            public float getAlpha() {
                // TODO Auto-generated method stub
                return 1.0f;
            }

        }), BorderLayout.CENTER);
        this.setVisible(true);
    }
}