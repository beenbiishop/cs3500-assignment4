package model;

public interface ImageTransformer {

  /**
   * Flips the image either horizontally or vertically depending on the given command
   *
   * @return the mutated image after being flipped.
   */
  public void flip();

  /**
   * Brightens or darkens the image
   *
   * @return the mutated image after being flipped.
   */
  public void shade(int con); //brightens or darkens the image accordingly
  public void greyscaleImage(); //converts the image to greyscale
  public void visualizeRGB();

  public enum visualType {
    RED, GREEN, BLUE, VALUE, INTENSITY, LUMA
  }
}
