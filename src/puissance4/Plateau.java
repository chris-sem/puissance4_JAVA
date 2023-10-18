package seprojet;

public class Plateau {
    private final int colonne=7 ;
    private final int ligne=6;
    private int [][] tab ;
    
    public Plateau()
    {
        tab = new int [ligne][colonne] ;
        for(int i=0 ; i<ligne ; i++)
        {
            for(int j=0 ; j<colonne ; j++)
            {
                tab[i][j] = 0 ;//Mettre toutes les cases à 0 ;
            }
        }
    }
    
    void afficherPalteau()
    {
        for(int i=0 ; i<ligne ; i++)
        {
            for(int j=0 ; j<colonne ; j++)
            {
                System.out.print(tab[i][j]+"  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }
    
    int pionAt(int i , int j)
    {
        if(i>5 || i<0 || j>6 || j<0)
            return(0);
        return (tab[i][j]) ;
    }
    
    boolean placer(int c , int unOUdeux)//c, est le numero de la colonne 
    {
        for(int i=0; i<ligne ; i++)
        {
            if(tab[i][c] == 0)
            {
                tab[i][c] = unOUdeux ;
                return i != 5 ;
            }
        }
        return false ;
    }
    
    boolean plein()
    {
        for(int i=0 ; i<ligne ; i++)
        {
            for(int j=0 ; j<colonne ; j++)
            {
                if(tab[i][j] == 0)
                    return false ;
            }
        }
        return true ;
    }
    
    boolean verification(int a , int i , int j)
    {
        return (pionAt(i,j)==a && pionAt(i,j+1)==a && pionAt(i,j+2)==a && pionAt(i,j+3)==a)||(pionAt(i,j)==a && pionAt(i+1,j)==a && pionAt(i+2,j)==a && pionAt(i+3,j)==a)||(pionAt(i,j)==a && pionAt(i+1,j+1)==a && pionAt(i+2,j+2)==a && pionAt(i+3,j+3)==a)||(pionAt(i,j)==a && pionAt(i+1,j-1)==a && pionAt(i+2,j-2)==a && pionAt(i+3,j-3)==a) ;
    }
    
    int verif()//retourne 0 quand il y'a RAS, retourne 1 qd j1 gagne, retourne 2 qd j2 gagne, retourne 3 en cas de match nul
    {
        for(int i=0 ; i<ligne ; i++)
        {
            for(int j=0 ; j<colonne ; j++)
            {
                if(verification(1 ,i , j))
                    return 1 ;
                if(verification(2 , i , j))
                    return 2 ;
            }
        }
        
        if(plein())
            return 3 ;
        return 0 ;
    }
            
    
}

/*

 Graphics2D ds = (Graphics2D)jPanel1.getGraphics();
        Image image = null ;
        
        try {
            image = ImageIO.read(new File("p1.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Jeux.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ds.drawImage(image, 0, 0, 50, 50, this) ;

*/
