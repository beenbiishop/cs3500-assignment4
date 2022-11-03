package controller;

import model.StoredImages;

public interface ImageProcessorCommand {

  void execute(StoredImages storedImages);

}
