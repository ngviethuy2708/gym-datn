package bean;

import java.util.ArrayList;

import javax.management.Query;






import org.apache.jena.iri.impl.Main;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.util.FileManager;

public class SparQlTest {
	/*public static void main(String[] args) {
		FileManager.get().addLocatorClassLoader(Main.class.getClassLoader());
		Model model = FileManager.get().loadModel("D:/Product2.owl");
		String queryString = 
					"PREFIX pr: <http://www.semanticweb.org/win/ontologies/2016/9/untitled-ontology-9#>"+
						"SELECT * WHERE {"
						+ " ?x pr:Weightgain pr:Germany."
						+ "?x pr:Name ?Name.}";
		org.apache.jena.query.Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query,model);
		ResultSet result = qexec.execSelect();
		try {
			while(result.hasNext()){
				QuerySolution soln = result.nextSolution();
				Literal name = soln.getLiteral("Name");
				System.out.println(name);
			}
		} finally{
			qexec.close();
		}
	}*/
	public static void main(String[] args) {
		ArrayList<Product> alPro = searchProduct("Weightgain","Germany");
		for (Product product : alPro) {
			System.out.println(product.getNameProduct());
		}
	}
	public static ArrayList<Product> searchProduct(String productCategories,String madeIn){
		String queryString = 
				"PREFIX pr: <http://www.semanticweb.org/win/ontologies/2016/9/untitled-ontology-9#>"+
					"SELECT * WHERE {"
					+ " ?x pr:"+productCategories+" pr:"+madeIn+"."
					+ "?x pr:Name ?Name.}";
		ResultSet result = OpenOWL.ExecSparQl(queryString);
		ArrayList<Product> alPro =  new ArrayList<Product>();
		while(result.hasNext()){
			QuerySolution soln = result.nextSolution();
			String name = soln.get("Name").toString();
			Product objPro = new Product(name);
			alPro.add(objPro);
		}
		return alPro;	
	}
}
