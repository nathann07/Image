package com.comp301.a06image;

import java.awt.Color;
import java.io.IOException;
import javafx.application.Application;

public class Main {
  /**
   * Creates and returns an image object for testing. The image that this method produces will be
   * automatically displayed on the screen when main() is run below. Use this method to test
   * different decorators.
   */
  public static Image makeImage() throws IOException {
    Color red = new Color(255, 0, 0);
    Color blue = new Color(0, 0, 255);
    Color yellow = new Color(255, 255, 0);
    Color orange = new Color(200, 80, 10);
    Image a = new PictureImage("img/cloudy sky.jpg");
    a = new BorderDecorator(a, 5, red);
    a = new BorderDecorator(a, 50, blue);
    a = new CircleDecorator(a, 50, 50, 40, yellow);
    a = new SquareDecorator(a, 100, 100, 40, orange);
    a = new ZoomDecorator(a);
    return a;
  }

  /**
   * Use this method for running the code. When main() runs, the image created and decorated in
   * the makeImage() method above will be generated and displayed on the screen.
   */
  public static void main(String[] args) {
    Application.launch(ImageDisplay.class, args);
  }
}
