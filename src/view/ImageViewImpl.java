package view;

import java.io.IOException;

import model.Image;

public class ImageViewImpl implements ImageView {

  private Image image;
  private Appendable appendable;


  public ImageViewImpl(Image image, Appendable appendable) {
    this.image = image;
    this.appendable = appendable;
    if (image == null || appendable == null) {
      throw new IllegalArgumentException("Null object");
    }
  }

  /**
   * Render a specific message to the provided data destination.
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException{
    this.appendable.append(message);
  }
}
