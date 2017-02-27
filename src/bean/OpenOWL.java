package bean;




import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;

/**
 *
 *
 * @author Ila Idias Tunisia (2012-2013)
 *
 *
 *
 */

class OpenOWL {

     static  String  s;

      // Open a connection to MonFichierOwl.OWL

     static  org.apache.jena.ontology.OntModel OpenConnectOWL(){
        
    org.apache.jena.ontology.OntModel mode = null;
    mode = org.apache.jena.rdf.model.ModelFactory.createOntologyModel( org.apache.jena.ontology.OntModelSpec.OWL_MEM_RULE_INF );
    java.io.InputStream in = org.apache.jena.util.FileManager.get().open( "D:/Product2.owl" );  //MyFile

    //test
    if (in == null) {
        throw new IllegalArgumentException("Pas de base de connaissance");  // there i no file to connect
    }
        return  (org.apache.jena.ontology.OntModel) mode.read(in, "");
    }


    // jena.query.ResultSet  return

     static  ResultSet ExecSparQl(String Query){
         
          org.apache.jena.query.Query query = org.apache.jena.query.QueryFactory.create(Query);

                org.apache.jena.query.QueryExecution qe = org.apache.jena.query.QueryExecutionFactory.create(query, OpenConnectOWL());
                ResultSet results = qe.execSelect();

                return results;  // Retrun jena.query.ResultSet 
         
     }

     // String return (convert jena.query.ResultSet  to String)

      static  String ExecSparQlString(String Query){
        try {
            org.apache.jena.query.Query query = org.apache.jena.query.QueryFactory.create(Query);

                  org.apache.jena.query.QueryExecution qe = org.apache.jena.query.QueryExecutionFactory.create(query, OpenConnectOWL());

                  ResultSet results = qe.execSelect();

                  // Test
                  if(results.hasNext()){

                  	// if iS good 

                     ByteArrayOutputStream go = new ByteArrayOutputStream ();
                    org.apache.jena.query.ResultSetFormatter.out((OutputStream)go ,results, query);
                  //  String s = go.toString();
                       s = new String(go.toByteArray(), "UTF-8");
                   }
                   // not okay
                  else{

                      s = "rien";
                  }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(OpenOWL.class.getName()).log(Level.SEVERE, null, ex);
        }
         return s;   // return  jena.query.ResultSet  as string 
      }
    public ResultSet ExacSparQl(String Query){
    	Query query = QueryFactory.create(Query);
    	QueryExecution qe = QueryExecutionFactory.create(query,OpenConnectOWL());
    	ResultSet result = qe.execSelect();
    	return result;
    }
}
