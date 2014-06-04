package com.github.howto.systemrules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.StandardErrorStreamLog;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

public class MaClasseTest
{
   /** La Rule permettant de vérifier les appels à System.exit. */
   @Rule
   public final ExpectedSystemExit m_exit = ExpectedSystemExit.none();

   /** La Rule permettant de vérifier le contenu de la sortie standard. */
   @Rule
   public final StandardErrorStreamLog m_err = new StandardErrorStreamLog();

   /** La Rule permettant de vérifier le contenu de la sortie standard. */
   @Rule
   public final StandardOutputStreamLog m_out = new StandardOutputStreamLog();

   private MaClasse m_SUD;

   @Before
   public void setUp()
   {
      m_SUD = new MaClasse();
   }

   @Test
   public void testExit()
   {
      m_exit.expectSystemExitWithStatus(5);
      m_exit.checkAssertionAfterwards(new Assertion()
      {
         public void checkAssertion() throws Exception
         {
            Assert.assertTrue(m_SUD.isSortie());
         }
      });

      m_SUD.exit(true);
   }

   @Test
   public void testOut()
   {
      m_SUD.out("ma super string");

      Assert.assertEquals("sysout : ma super string\n", m_out.getLog());
      Assert.assertEquals("", m_err.getLog());
   }

   @Test
   public void testErr()
   {
      m_SUD.err("ma super string");

      Assert.assertEquals("syserr : ma super string\n", m_err.getLog());
      Assert.assertEquals("", m_out.getLog());
   }
}
