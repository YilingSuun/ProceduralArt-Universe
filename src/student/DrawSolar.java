package student;

import java.awt.*;

public class DrawSolar {
    /**
     * main function that can draw a solar system in a file.
     * @param args
     */
    public static void main(String[] args) {
        ShapeDrawer myDraw = new ShapeDrawer(400, 400);
        //Sun
        Point sunCenter = new Point(200, 200);
        Circle sun = new Circle(sunCenter, 25);
        //earth
        Ring earthOrbit = new Ring(new Circle(sunCenter, 100), 2);
        Point earthCenter = new Point(300, 200);
        earthCenter.rotateAroundOrigin((int)(Math.random()*360), sunCenter);
        Circle earth = new Circle(earthCenter, 10);
        //moon
        Ring moonOrbit = new Ring(new Circle(earthCenter, 30), 1);
        Point moonCenter = new Point(earthCenter.getX() + 30, earthCenter.getY());
        moonCenter.rotateAroundOrigin((int)(Math.random()*360), earthCenter);
        Circle moon = new Circle(moonCenter, 5);
        //jupiter
        Ring jupiterOrbit = new Ring(new Circle(sunCenter, 130), 2);
        Point jupiterCenter = new Point(330, 200);
        jupiterCenter.rotateAroundOrigin((int)(Math.random()*360), sunCenter);
        Circle jupiter = new Circle(jupiterCenter, 16);
        //little star
        Circle[] star = new Circle[30];
        for (int i = 0; i < 30; i++) {
            star[i] = new Circle(new Point(Math.random()*400, Math.random()*400), Math.random()*1.5);
        }
        //draw the objects with their filled colors
        myDraw.setFill(Color.ORANGE);
        myDraw.setStroke(Color.ORANGE);
        myDraw.draw(sun);

        myDraw.setFill(Color.cyan);
        myDraw.setStroke(Color.cyan);
        myDraw.draw(earth);

        myDraw.setFill(Color.yellow);
        myDraw.setStroke(Color.yellow);
        myDraw.draw(moon);

        myDraw.setFill(Color.white);
        myDraw.setStroke(Color.white);
        myDraw.draw(earthOrbit);
        myDraw.draw(moonOrbit);
        myDraw.draw(jupiterOrbit);
        for (int i = 0; i < star.length; i++) {
            myDraw.draw(star[i]);
        }

        myDraw.setFill(Color.pink);
        myDraw.setStroke(Color.pink);
        myDraw.draw(jupiter);

        myDraw.writeToFile("solar.png");
    }
}
