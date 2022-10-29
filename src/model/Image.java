package model;

public interface Image {

  public void visualizeImage();

  public void horizontalFlip();
  public void verticalFlip();

  public void shadeImage(); //brightens or darkens the image accordingly
  public void greyscaleImage(); //converts the image to greyscale
}
