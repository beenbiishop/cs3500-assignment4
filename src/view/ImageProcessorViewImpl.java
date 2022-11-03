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
  public void renderMessage(String message) throws IOException {
    this.appendable.append(message);
  }
}
