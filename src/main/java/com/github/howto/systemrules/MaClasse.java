package com.github.howto.systemrules;

public class MaClasse
{
   private boolean sortie = false;

   public void exit(boolean p_exit)
   {
      if (true == p_exit)
      {
         sortie = true;
         System.exit(5);
      }
      else
      {
         sortie = false;
      }
   }

   public void out(String p_chaine)
   {
      System.out.println("sysout : " + p_chaine);
   }

   public void err(String p_chaine)
   {
      System.err.println("syserr : " + p_chaine);
   }

   public boolean isSortie()
   {
      return sortie;
   }
}
