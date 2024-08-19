package com.niantic.part_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTests
{
    private Rectangle rectangle;

    @BeforeEach
    public void setup() { rectangle = new Rectangle(); }

    @Test
    public void rectangleParameterless_shouldCreate_5x5Rectangle()
    {
        // Arrange
        int expectedWidth = 5;
        int expectedHeight = 5;

        // Act
        int actualWidth = rectangle.getWidth();
        int actualHeight = rectangle.getHeight();

        // Assert
        assertEquals(expectedWidth, actualWidth, "Because default Rectangle() width should be 5");
        assertEquals(expectedHeight, actualHeight, "Because default Rectangle() height should be 5");
    }

    @Test
    public void getArea_shouldReturn_widthTimesHeight()
    {
        // Arrange
        int width = 8;
        int height = 3;
        int expectedArea = 24;

        // Act
        rectangle = new Rectangle(width, height);
        int actualArea = rectangle.getArea();

        // Assert
        assertEquals(expectedArea, actualArea, "Because area for width:8 x height:3 should be 24");
    }

    @Test
    public void getPerimeter_shouldReturn_width2PlusHeight2()
    {
        // Arrange
        int width = 15;
        int height = 12;
        int expectedPerimeter = 54;

        // Act
        rectangle = new Rectangle(width, height);
        int actualPerimeter = rectangle.getPerimeter();

        // Assert
        assertEquals(expectedPerimeter, actualPerimeter, "Because perimeter for width:15 + height:12 should be 27");
    }

//    @Test
//    public void rectWidthHeight_shouldBe_positive()
//    {
//        // Arrange
//        int width = -7;
//        int height = -5;
//        int expectedWidth = 0;
//        int expectedHeight = 0;
//
//        // Act
//        rectangle = new Rectangle(width, height);
//        int actualWidth = rectangle.getWidth();
//        int actualHeight = rectangle.getHeight();
//
//        // Assert
//        assertEquals(expectedWidth, actualWidth, "Because width must be positive so width:-7 should be 0");
//        assertEquals(expectedHeight, actualHeight, "Because height must be positive so height:-5 should be 0");
//    }

    @Test
    public void getArea_shouldReturn_positive()
    {
        // Arrange
        int width = -9;
        int height = 3;
        int expectedArea = 0;

        // Act
        rectangle = new Rectangle(width, height);
        int actualArea = rectangle.getArea();

        // Assert
        assertEquals(expectedArea, actualArea, "If either width or height is negative, getArea() should return 0");
    }

    @Test
    public void getPerimeter_shouldReturn_zeroWhenNegativeWidthOrHeight()
    {
        // Arrange
        int width = 25;
        int height = -8;
        int expectedPerimeter = 0;

        // Act
        rectangle = new Rectangle(width, height);
        int actualPerimeter = rectangle.getPerimeter();

        // Assert
        assertEquals(expectedPerimeter, actualPerimeter, "If either width or height is negative, getArea() should return 0");
    }

    @Test
    public void getPerimeter_shouldReturn_zeroWhenZeroWidthOrHeight()
    {
        // Arrange
        int width = 0;
        int height = 32;
        int expectedPerimeter = 0;

        // Act
        rectangle = new Rectangle(width, height);
        int actualPerimeter = rectangle.getPerimeter();

        // Assert
        assertEquals(expectedPerimeter, actualPerimeter);
    }
}