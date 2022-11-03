package view;

import java.io.IOException;

public class ImageProcessorViewImpl implements ImageProcessorView {

  private Appendable appendable;

  /**
   * Constructs a new ImageProcessorViewImpl object with the given appendable.
   *
   * @param appendable the appendable to append the text to
   */
  public ImageProcessorViewImpl(Appendable appendable) {
    this.appendable = appendable;
  }

  @Override
  public void renderMessage(String message) throws IllegalStateException {
    try {
      this.appendable.append(message);
    } catch (IOException e) {
      throw new IllegalStateException("Unable to render message");
    }
  }


  @Override
  public void renderMenu() throws IllegalStateException {
    this.renderMessage(
        "load <filename> - loads the image from the given file" + System.lineSeparator());
    this.renderMessage("save <filename> - saves the image to the given file\n");
    this.renderMessage("menu - displays the menu of commands\n");
    this.renderMessage("brighten - brightens the image\n");
    this.renderMessage("darken - darkens the image\n");
    this.renderMessage("horizontal-flip - flips the image horizontally\n");
    this.renderMessage("vertical-flip - flips the image vertically\n");
    this.renderMessage(
        "visualize-<component> - transforms the image to greyscale using a chosen component\n");
    this.renderMessage("quit - quits the program\n");
  }

}
