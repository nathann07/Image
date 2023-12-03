# Image

## Introduction

This program utilizes the decorator design pattern. It consists of a series of base classes and decorator classes to make up a final digital image, similar to how social media apps allow different filters or effects to be overlaid onto pictures.

In the program, the decorator pattern is used to add visual modifications to the original picture.

For example, one decorator class adds a border around an existing image; another decorator superimposes a configurable circle somewhere on the image. The order in which you add the decorators to the base image will determine the order in which the modifications will appear on the final result.

In the current MakeImage method (located in Main.java), I have taken the original image of a cloudy sky (which is located in the img folder) and performed the following modifications to it:

	Image a = new PictureImage("img/cloudy sky.jpg");
	a = new BorderDecorator(a, 5, red);
	a = new BorderDecorator(a, 50, blue);
	a = new CircleDecorator(a, 50, 50, 40, yellow);
	a = new SquareDecorator(a, 100, 100, 40, orange);
	a = new ZoomDecorator(a);
	return a;

* The base image is `img/cloudy sky.jpg`
* The red border is color `(255, 0, 0)` and has a thickness of `5` (before scaling)
* The blue border is color `(0, 0, 255)` and has a thickness of `50` (before scaling)
* The yellow circle is color `(255, 255, 0)`, has radius `40` (before scaling), and is at position `(50, 50)` in the final, unscaled image
* The orange square is color `(200, 80, 10)`, has size `40` (before scaling), and is at position `(100, 100)` in the final, unscaled image
* After applying these decorators, add one last `ZoomDecorator` with a multiplier of `2`, to make the image bigger

However, any combination of these decorators can be applied to the image freely, in any desired order.


### Image interface

Every class you will create for this assignment should implement the `Image` interface, which is already provided in the starter code. An `Image` object represents a digital image. Digital images are made up of a two-dimensional grid of "pixels", which are essentially minuscule rectangles of color.

Every `Image` has a width and a height, referring to the number of horizontal and vertical pixels in the image. The `Image` interface therefore has `getWidth()` and `getHeight()` getter methods for getting these values.

To get the color of a pixel, use the `getPixelColor()` method. `getPixelColor()` takes an `x` and a `y` value as parameters, representing the location of the pixel to get. And `getPixelColor()` returns a `Color` object, representing the color of the requested pixel.

The `Image` interface also has a `numLayers()` getter method for getting the number of "layers" in the image. Base images, which do not have any decorators, have only one layer. Each decorator added to an image (like a shape or a border) is another "layer" added to the image. So, for instance, if a base image has one border decorator and one square decorator, then the image has a total of 3 layers.


### SolidColorImage

The `SolidColorImage` class represents a blank image that is a solid color, sort of like a background.


### PictureImage

The other base image class is `PictureImage`, which represents an existing image from your computer.


### SquareDecorator

This decorator class should superimpose a configurable square on top of an existing image.


### CircleDecorator

This decorator is very similar to `SquareDecorator`, except it decorates the underlying image with a circle instead of with a square.


### BorderDecorator

The `BorderDecorator` class decorates an image by surrounding it with a solid-color border.

`thiccness` represents the thickness of the border, and `borderColor` represents the color of the border.

`BorderDecorator` expands the height and width of the underlying image to account for the border being added. For example, if `thiccness` is 10, that means 20 pixels are added to the width of the image---10 pixels for the left border, and 10 pixels for the right border. A similar computation takes place for the top and bottom borders.


### ZoomDecorator

The `ZoomDecorator` class decorates an existing image by scaling the image so that it appears larger.

Here, `multiplier` is a positive integer referring to the factor by which the image should be scaled. A multiplier of `1` indicates that the image should not be scaled at all. A multiplier of `2` means the width and height should be doubled, and so on.

If the 'multiplier' constructor is omitted, 'ZoomDecorator' uses a default multiplier value of `2`. Constructor chaining is used to accomplish this.

In addition to simply increasing the width and height of the image, this class also stretches the original image to fit the new size. This modification takes place in the `getPixelColor()` method. For example, if the original image has a height and width of `2`, and the zoom multiplier is `2`, then the decorated image has a height of `4` and a width of `4`, but the underlying pixels are scaled so that `getPixelColor(0, 0)`, `getPixelColor(0, 1)`, `getPixelColor(1, 0)`, and `getPixelColor(1, 1)` all return the same pixel color---that is, they return the same color as the pixel located at position `(0, 0)` in the original picture. In other words, each pixel value in the original pixel is mapped to four pixels in the scaled image.