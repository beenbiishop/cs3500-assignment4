package view;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the ImageProcessorViewImpl class and its methods.
 */
public class ImageProcessorViewImplTest {

  ImageProcessorView view;
  Appendable appendable;

  @Before
  public void setUp() {
    this.appendable = new StringBuilder();
    this.view = new ImageProcessorViewImpl(appendable);
  }

  @Test
  public void renderMessage() {
    this.view.renderMessage("Message to Render.");
    assertEquals("Message to Render.", this.appendable.toString());
  }

  @Test
  public void renderMenu() {
    this.view.renderMenu();
    assertEquals("quit - quits the program" + System.lineSeparator() +
            "load <path> <filename> - loads an image (identified by given name) into the processor" + System.lineSeparator() +
            "save <path> <filename> - saves an image to an output file" + System.lineSeparator() +
            "menu - displays the menu of commands" + System.lineSeparator() +
            "visualize-<component> <filename> <new filename> - transforms an image to a new image greyscaled using a chosen component" + System.lineSeparator() +
            "brighten <amount> <filename> <new filename> - transforms an image to a new image brightened by an amount" + System.lineSeparator() +
            "darken <amount> <filename> <new filename> - transforms an image to a new image darkened by an amount" + System.lineSeparator() +
            "horizontal-flip <filename> <new filename> - horizontally flips an image to a new image" + System.lineSeparator() +
            "vertical-flip <filename> <new filename> - vertically flips an image to a new image" + System.lineSeparator(), this.appendable.toString());
  }
}