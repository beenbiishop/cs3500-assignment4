package model;

public interface ImageTransformer {

  public void horizontalFlip();
  public void verticalFlip();

  public void shadeImage(int con); //brightens or darkens the image accordingly
  public void greyscaleImage(); //converts the image to greyscale
}
