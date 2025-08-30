package service;

import models.Snickers;

public interface SnickersService {
    void createSnickers(Snickers snick);
    Snickers[] getAllSnickers();
    Snickers getByNameSnickers(String nameType);
    void updateSnickersByName(String nameType, Snickers newSnickers);
    void deleteSnickersByBarcode(String barcode);
}
