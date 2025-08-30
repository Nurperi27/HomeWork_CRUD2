package service.impl;

import models.Snickers;
import service.SnickersService;

public class SnickersServiceImpl implements SnickersService {
    //todo DB-Array
    Snickers[] snickersArr = new Snickers[10];
    int count; //счётчик
    @Override
    public void createSnickers(Snickers snick) {
        snickersArr[count++] = snick; //new snickers
        System.out.println("Data is created!");
    }
    //todo READ
    @Override
    public Snickers[] getAllSnickers() {
        return snickersArr;
    }

    @Override
    public Snickers getByNameSnickers(String nameType) {
//        boolean isblock = false;
        for(Snickers s : snickersArr){
            if(s.getNameType().equals(nameType)){
                //isblock = true;
                return s;
            }
        }
//        if(!isblock){
//            System.out.println("Name-type is not found!");
//        }
        return null;
    }

    @Override
    public void updateSnickersByName(String nameType, Snickers newSnickers) {
        Snickers oldSnickers = getByNameSnickers(nameType);
        //меняем данные
        oldSnickers.setNameType(newSnickers.getNameType());
        oldSnickers.setWeight(newSnickers.getWeight());
        oldSnickers.setBarcode(newSnickers.getBarcode());
        oldSnickers.setPrice(newSnickers.getPrice());
        oldSnickers.setCount(newSnickers.getCount());
        System.out.println("Data success changed!");
    }
    //удялаяем по штрих-коду
    @Override
    public void deleteSnickersByBarcode(String barcode) {
        boolean isblock = false;
        for(int i = 0; i < count; i++){
            if(snickersArr[i].getBarcode().equals(barcode)){
                isblock = true;
                for(int j = 0; j < count - 1; j++){
                    snickersArr[j] = snickersArr[j+1];
                }
                count--;
                System.out.println("Deleted!");
                for(int k = 0; k < count; k++){
                    System.out.println("All snickers: " + snickersArr[k]);
                }
            }
        }
        if(!isblock){
            System.out.println("No such barcode" + barcode + " of snickers was found!");
        }
    }
}
