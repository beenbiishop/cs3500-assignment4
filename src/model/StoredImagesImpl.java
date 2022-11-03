package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements the {@link StoredImages} interface.
 */

public class StoredImagesImpl implements StoredImages {

  private Map<String, Image> storedImages;

  /**
   * Constructs a new empty image storage object.
   */
  public StoredImagesImpl() {
    this.storedImages = new HashMap<>();
  }

  @Override
  public void add(String fileName, Image image, boolean force) {
    if (this.exists(fileName) && force) {
      this.storedImages.put(fileName, image);
    } else if (this.exists(fileName) && !force) {
      throw new IllegalArgumentException("An image with that file name already exists");
    }
  }

  @Override
  public void remove(String fileName) {
    this.storedImages.remove(fileName);
  }

  @Override
  public boolean exists(String fileName) {
    boolean exists = false;

    for (Map.Entry<String, Image> entry : this.storedImages.entrySet()) {
      if (fileName.equals(entry.getKey())) {
        exists = true;
        break;
      }
    }
    return exists;
  }

  @Override
  public Image retrieve(String fileName) throws IllegalArgumentException {
    if (!this.exists(fileName)) {
      throw new IllegalArgumentException("Image does not exist.");
    } else {
      return this.storedImages.get(fileName).copy();
    }
  }

}
