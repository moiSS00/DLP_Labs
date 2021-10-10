package codegenerator;

import ast.*;
import ast.CharType;
import ast.DoubleType;
import ast.IntType;
import ast.Type;

import java.io.IOException;
import java.io.PrintWriter;

public class CodeGenerator {

    private PrintWriter out;
    private int labelCount;

    public CodeGenerator(String sourceFileName, String outputFileName) {
        this.labelCount = 0;
        try {
            this.out = new PrintWriter(outputFileName);
        } catch (IOException e) {
            System.err.println("Error opening the file " + outputFileName + ".");
            System.exit(-1);
        }
        source(sourceFileName);
    }

    /*
    Get the next available label
    */
    public String getNextLabel() {
        String label = "label" + labelCount;
        labelCount++;
        return label;
    }

    /*
    Allows the MAPL IDE to associate assembly code to the high-level source program
    #source <string_constant>
    */
    public void source(String inputFileName) {
        out.println("\n#source\t\"" + inputFileName + "\"\n");
        out.flush();
    }

    /*
    Pushes the value of the bp register (2 bytes)
    push[a] bp
    */
    public void pushBP() {
        out.println("\tpush\tbp");
        out.flush();
    }

    /*
    Pushes the character (1 byte) onto the stack
    pushb <ASCII_code>
    */
    public void pushb(char constant) {
        out.println("\tpushb\t" + (int)constant);
        out.flush();
    }

    /*
    Pushes the integer literal (2 bytes) onto the stack
    push[i] <int_constant>
    */
    public void pushi(int constant) {
        out.println("\tpushi\t" + constant);
        out.flush();
    }

    /*
    Pushes the real number (4 bytes) onto the stack
    pushf <real_constant>
    */
    public void pushf(double constant) {
        out.println("\tpushf\t" + constant);
        out.flush();
    }

    /*
    Pushes the integer address (2 bytes) onto the stack
    pusha <int_constant>
    */
    public void pusha(int offset) {
        out.println("\tpusha\t" + offset);
        out.flush();
    }

    /*
    Pop a memory address off the stack (2 bytes).
    Then, they push onto the stack the content (1, 2 or 4 bytes) of
    the address popped in the previous point
    loadb, load[i], loadf
    */
    public void load(Type type) {
        out.println("\tload" + type.suffix());
        out.flush();
    }

    /*
    Pop from the stack 1, 2 or 4 bytes.
    Then, they pop from the stack a memory address (2 bytes).
    The content of the memory address is replaced with the value popped in the first step
    storeb, store[i], storef
    */
    public void store(Type type) {
        out.println("\tstore" + type.suffix());
        out.flush();
    }

    /*
    Pop 1, 2 or 4 bytes, respectively, off the stack
    popb, pop[i], popf
    */
    public void pop(Type type) {
        out.println("\tpop" + type.suffix());
        out.flush();
    }

    /*
    Duplicate the 1, 2 or 4 bytes, respectively, on the top of the stack
    dupb, dup[i], dupf
    */
    public void dup(Type type) {
        out.println("\tdup" + type.suffix());
        out.flush();
    }

    /*
    For addition
    add[i], addf
    */
    public void add(Type type) {
        out.println("\tadd" + type.suffix());
        out.flush();
    }

    /*
    For subtraction
    sub[i], subf
    */
    public void sub(Type type) {
        out.println("\tsub" + type.suffix());
        out.flush();
    }

    /*
    For multiplication
    mul[i], mulf
    */
    public void mul(Type type) {
        out.println("\tmul" + type.suffix());
        out.flush();
    }

    /*
    For division
    div[i], divf
    */
    public void div(Type type) {
        out.println("\tdiv" + type.suffix());
        out.flush();
    }

    /*
    For modulus
    mod[i], modf
    */
    public void mod(Type type) {
        out.println("\tmod" + type.suffix());
        out.flush();
    }

    /*
    For the "and" logical operation
    */
    public void and() {
        out.println("\tand");
        out.flush();
    }

    /*
    For the "or" logical operation
    */
    public void or() {
        out.println("\tor");
        out.flush();
    }

    /*
    For the unary "not" logical operation
    */
    public void not() {
        out.println("\tnot");
        out.flush();
    }

    /*
    For "greater than" comparison
    gt[i], gtf
    */
    public void greaterThan(Type type) {
        out.println("\tgt" + type.suffix());
        out.flush();
    }

    /*
    For "lower than" comparison
    lt[i], ltf
    */
    public void lessThan(Type type) {
        out.println("\tlt" + type.suffix());
        out.flush();
    }

    /*
    For "greater or equal" comparison
    ge[i], gef
    */
    public void greaterEqualThan(Type type) {
        out.println("\tge" + type.suffix());
        out.flush();
    }

    /*
    For "lower or equal than" comparison
    le[i], lef
    */
    public void lessEqualThan(Type type) {
        out.println("\tle" + type.suffix());
        out.flush();
    }

    /*
    For "equal to" comparison
    eq[i], eqf
    */
    public void equal(Type type) {
        out.println("\teq" + type.suffix());
        out.flush();
    }

    /*
    For "not equal" comparison
    ne[i], nef
    */
    public void notEqual(Type type) {
        out.println("\tne" + type.suffix());
        out.flush();
    }

    /*
    Pop one value off the stack and shows it in the console
    outb, out[i], outf
    */
    public void out(Type type) {
        out.println("\tout" + type.suffix());
        out.flush();
    }

    /*
    Read a value from the keyboard and pushes it onto the stack
    inb, in[i], inf
    */
    public void in(Type type) {
        out.println("\tin" + type.suffix());
        out.flush();
    }

    /*
    Conversions
    b2i 	Pops one character and pushes it as an integer
	i2f 	Pops one integer and pushes it as a real number
	f2i 	Pops one real number and pushes it as an integer
	i2b 	Pops one integer and pushes it as a character
    */
    public void a2b(Type originalType, Type finalType) {
        if(originalType instanceof CharType) {
            if(finalType instanceof IntType) {
                out.println("\tb2i");
            } else if(finalType instanceof DoubleType) {
                out.println("\tb2i");
                out.println("\ti2f");
            }
        } else if (originalType instanceof IntType) {
            if(finalType instanceof CharType) {
                out.println("\ti2b");
            } else if(finalType instanceof DoubleType) {
                out.println("\ti2f");
            }
        } else if (originalType instanceof DoubleType) {
            if(finalType instanceof IntType) {
                out.println("\tf2i");
            } else if(finalType instanceof CharType) {
                out.println("\tf2i");
                out.println("\ti2b");
            }
        }
        out.flush();
    }

    /*
    Jumps (unconditionally) to the label specified as a parameter
    jmp <label>
    */
    public void jmp(String label) {
        out.println("\tjmp\t" + label);
        out.flush();
    }

    /*
    Pops one integer and jumps to the label if the popped integer is zero
    jz <label>
    */
    public void jz(String label) {
        out.println("\tjz\t" + label);
        out.flush();
    }

    /*
    Pops one integer and jumps to the label if the popped integer is not zero
    jnz <label>
    */
    public void jnz(String label) {
        out.println("\tjnz\t" + label);
        out.flush();
    }

    /*
    Allocates <int_constant> bytes on the top of the stack
    enter <int_constant>
    */
    public void enter(int size) {
        out.println("\tenter\t" + size);
        out.flush();
    }

    /*
    Invokes the <id> function
    call <id>
    */
    public void call(String function) {
        out.println("\tcall\t" + function);
        out.flush();
    }

    /*
    Returns from a function invocation
    The first constant represents the bytes to return
    The second one, the bytes of all the local variables
    And the last one, the bytes of all the arguments
    ret <int_constant>, <int_constant>, <int_constant>
    */
    public void ret(int returnSize, int varsLocalSize, int paramsSize) {
        out.println("\tret\t" + returnSize + ", " + varsLocalSize + ", " + paramsSize);
        out.flush();
    }

    /*
    Terminates the program execution
    */
    public void halt() {
        out.println("halt");
        out.flush();
    }

    /*
    Defines a label for jumps and invocations (functions)
    <id>:
    */
    public void label(String labelId) {
        out.println("\n " + labelId + ":");
        out.flush();
    }

    /*
    For one-line comments
    */
    public void comment(String message) {
        out.println("\t' * " + message);
        out.flush();
    }

    /*
    Allows the MAPL IDE to associate the assembly code corresponding to each high-level statement
    #line <INT_CONSTANT>
    */
    public void line(ASTNode node) {
        out.println("\n#line\t" + node.getLine());
        out.flush();
    }

    /*
    Invocation of the main function
    */
    public void mainInvocation() {
        out.println();
        out.println("\' Invocation to the main function");
        out.println("call main");
        halt();
        out.println();
        out.flush();
    }

}
