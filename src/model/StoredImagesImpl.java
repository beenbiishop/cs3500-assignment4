package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a collection of stored Images. It Maps the filename of the Image to the Image.
 */

public class StoredImagesImpl implements StoredImages {

  Map<String, Image> storedImages

  public StoredImagesImpl(Map<String, Image> storedImages) {
    this.storedImages = new HashMap<>(storedImages);
  }

  public void add(String fileName, Image image, boolean force) {
    if (this.exists(fileName) && force) {
      this.storedImages.put(fileName, image);
    } else if (this.exists(fileName) && !force) {
      throw new IllegalArgumentException("Given filename is already stored.");
    }
  }

  public void remove(String fileName) {
    this.storedImages.remove(fileName);
  }

  boolean exists(String fileName) {
    for (Map.Entry<String, Image> () stored)
  }

  public Image retrieve(String fileName);

}
