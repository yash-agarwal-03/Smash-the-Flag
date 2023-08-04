import java.util.*;
class GameCode
{
    static Scanner k=new Scanner(System.in); 
    static int field[][];
    static int d;       //no. of flags
    
    GameCode()
    {
        field=new int[4][4];
        
    }
    
    void generator()
    {
        d=0;
        
        for(int i=0;i<=3;i++)                              //field generator
        {
            for(int j=0;j<=3;j++)
            {
                field[i][j]=(int)(Math.random()*10) % 2;
                
                if(field[i][j] == 1)
                    d++;            ///no. of flags
                }
        }
        
        if(d==0)
        {
            System.out.println("Error 404. Restart game");
            System.exit(0);
        }
        
    }
    
    int check(String ch, int i)
    {
        String y="yes";
        String n="NO";
        
        
            if(!y.equalsIgnoreCase(ch))         //if choice not equal to YES
            {
                if(!n.equalsIgnoreCase(ch))         //if choice not equal to NO
                {
                    if(i==0)
                    System.out.println("\tInvalid Input! CHOOSE YES or NO !!");
                    else
                    {
                        System.out.println("cr\f\tInvalid Input!    YES or NO !! \n You are banished from the game for idiocracy ");                ///idiocracy
                        return 0;
                    }
                }
                
                else            //if choice equal to NO
                {        
                    System.out.println("\nAre you sure? \n YES or NO");
                    ch=k.next();
                    if(y.equalsIgnoreCase(ch))            //if "are u sure" choice equal to YES
                    {
                       System.out.println("\nThen see you later");
                        return 0;  
                    }
                    
                    else if(i==1 || !n.equalsIgnoreCase(ch))        //choice not equal to NO for 2nd time
                    {
                        System.out.println("cr\f\tInvalid Input!    YES or NO ?!! \n You are banished from the game for idiocracy ");            //idiocracy
                        return 0;
                    }
                    
                    else            //choice equal to no
                    return -1;
                }
            }
        
        return 1;
    }
    
    
    void display()
    {
        //instructions print 
        String ch;
        
        System.out.println("cr\f\t\t\t\t Welcome to SMASH-HIT \n\n INSTRUCTIONS:- \n\nTotal flags =" + d +
                            " \nEnter coordinates of the flag to hit (x,y). \nCoordinates range from (0,0) to (3,3)  \nSmash all under " + (d+4) + " hits and you win \n\n");
                            
        System.out.println("\n Your field is : \n");
        
        for(int i=0;i<=3;i++)                       //field dislpay
        {
            for(int j=0;j<=3;j++)
            System.out.print("\t" + field[i][j]);
                
            System.out.println();
        }
        
        for(int i=0;i<2;i++)
        {
            System.out.println("\nReady to play?? \n YES or NO ");     //start choice
            ch=k.next();
            int c=check(ch,i);
            if(c==0)
            System.exit(0);
            
            else if(c==1)
            break;
        }
        
        System.out.println("cr\f");         //clear screen
    }
    
    void gameRun()
    {
        int tries=0, smash=0, win=0;
        
        while(tries<(d+4))                                      //game iterations
        {
            int r=-1,c=-1; 
            System.out.println("\nHits Left : " + ((d+4) - (tries) ) + "\n\nFlags SMASHED : " + smash + "\nFlags Left: : " + (d-smash) + "\n\nEnter flag position\n");
            
            System.out.println("\nX= ");
            r=k.nextInt();
                
            System.out.println("\nY= ");
            c=k.nextInt();
            System.out.println("cr\f");
            
            if(r<0 || r>3 || c>3 || c<0 )
            {
                System.out.println(" Invalid point!!!! \nTRY AGAIN");
                continue;
            }
            
            tries++;
                
                if(field[r][c]==1)
                {
                    smash++;
                    field[r][c]=0;
                    System.out.println("\n\t\t\tThat was a SMASH!!!");
            
                if(smash==d)
                {
                    win++;
                    break;
                }
                }
            else
            System.out.println("\n\t\t\tThat was a MISS  :(");
            
        }                    //iteration ends
            
        System.out.println("cr\f"); 
            
        if(win==1)
            System.out.println("\t\t\t\t\tVictory !!! \n\nYou won in " + tries +  "hits");
        else
        System.out.println("\t\t\tYou LOST!! \nFlags Smashed: "+smash+ "\nFlags Left: : " + (d-smash));
    }
}
