package ast;

import visitor.Visitor;

public interface ASTNode {
    int getLine();
    int getColumn();
    Object accept(Visitor visitor, Object o);
}
