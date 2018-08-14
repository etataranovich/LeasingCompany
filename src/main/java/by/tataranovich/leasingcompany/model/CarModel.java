package by.tataranovich.leasingcompany.model;

public enum CarModel {
  
    AUDI(1, "audi"),
    PEGO(2, "pego"),
    TEPO(3, "tepo"),
    LADA(4, "lada"),
    MAZ(5, "maz"),
    DUSTER(6, "duster"),
    MAZDA(7, "mazda"),
    INFINITY(8, "infinity"),
    RENO(9, "reno"),
    BMW(10, "bmv");
    
    private int id;
    private String name;
    
  
    CarModel(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }

    public static CarModel getById(int id) {
        switch (id) {
            case 1: return AUDI;
            case 2: return PEGO;
            case 3: return TEPO;
            case 4: return LADA;
            case 5: return MAZ;
            case 6: return DUSTER;
            case 7: return MAZDA;
            case 8: return INFINITY;
            case 9: return RENO;
            case 10: return BMW;          
            
            default: throw new IllegalArgumentException("Unknown car model id = " + id);
        }
        
        
    }
//    public static CarModel getEnum(int int1) {
//	// TODO Auto-generated method stub
//	return null;
//    }
}


