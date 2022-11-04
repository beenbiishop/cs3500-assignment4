package view;

import static org.junit.Assert.assertEquals;

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
  public void testRenderMessage() {
    this.view.renderMessage("Message to Render.");
    assertEquals("Message to Render.", this.appendable.toString());
  }

  @Test
  public void testRenderMenu() {
    this.view.renderMenu();
    StringBuilder sb = new StringBuilder();
    sb.append("Supported commands:" + System.lineSeparator());
    sb.append("* \"quit\" - quits the program" + System.lineSeparator());
    sb.append("* \"menu\" - displays the menu of commands" + System.lineSeparator());
    sb.append("* \"load\" <path> <filename> - loads an image (identified by given name)");
    sb.append(" into the processor" + System.lineSeparator());
    sb.append("* \"save\" <path> <filename> - saves an image to an output");
    sb.append(" file" + System.lineSeparator());
    sb.append("* \"visualize-<component>\" <filename> <new filename> - transforms an image to");
    sb.append(" a new greyscale image using a chosen component" + System.lineSeparator());
    sb.append("* \"brighten\" <amount> <filename> <new filename> - transforms an image to a new");
    sb.append(" image brightened by an amount" + System.lineSeparator());
    sb.append("* \"darken\" <amount> <filename> <new filename> - transforms an image to a new");
    sb.append(" image darkened by an amount" + System.lineSeparator());
    sb.append("* \"horizontal-flip\" <filename> <new filename> - horizontally flips an image");
    sb.append(" to a new image" + System.lineSeparator());
    sb.append("* \"vertical-flip\" <filename> <new filename> - vertically flips an image");
    sb.append(" to a new image" + System.lineSeparator());
    assertEquals(sb.toString(), this.appendable.toString());
  }
}