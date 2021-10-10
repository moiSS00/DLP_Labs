import codegenerator.CodeGenerator;
import codegenerator.ExecuteCGVisitor;
import codegenerator.OffsetVisitor;
import parser.*;

import org.antlr.v4.runtime.*;

import ast.Program;
import errorhandler.EH;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import semantic.IdentificationVisitor;
import semantic.TypeCheckingVisitor;
import visitor.Visitor;

public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<1) {
		        System.err.println("Please, pass me the input file.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		PmmLexer lexer = new PmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		PmmParser parser = new PmmParser(tokens);	
		Program ast = parser.program().ast;

		// create the visitors
		Visitor IdentificationVisitor = new IdentificationVisitor();
		Visitor typeCheckingVisitor = new TypeCheckingVisitor();
		Visitor offsetVisitor = new OffsetVisitor();
		Visitor executeCGVisitor = new ExecuteCGVisitor(new CodeGenerator(args[0], args[1]));


		// * Check errors 
		if(EH.getEH().hasErrors()){
			// * Show errors
			EH.getEH().showErrors(System.err);
		}
		else{
			ast.accept(IdentificationVisitor, null);
			ast.accept(typeCheckingVisitor,null);

			if(EH.getEH().hasErrors()){
				// * Show errors
				EH.getEH().showErrors(System.err);
			}
			else {
				ast.accept(offsetVisitor,null);
				ast.accept(executeCGVisitor, null);
				// * The AST is shown
				//IntrospectorModel model=new IntrospectorModel("Program", ast);
				//new IntrospectorTree("Introspector", model);
			}
		}
	}
}
