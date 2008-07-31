// example from Nice documentation: http://nice.sourceforge.net/visitor.html
package syntax;

abstract class ExpressionVisitor 
{ 
  abstract void visitIntExp(IntExp e); 
  abstract void visitAddExp(AddExp e); 
} 

abstract class Expression 
{ 
  abstract void accept(ExpressionVisitor v); 
} 

class IntExp extends Expression 
{ 
  int value; 

  void accept(ExpressionVisitor v)
  {
    v.visitIntExp(this);
  }
} 

class AddExp extends Expression 
{ 
  Expression e1, e2; 

  void accept(ExpressionVisitor v)
  {
    v.visitAddExp(this);
  }
} 

// Behaviour can now be defined on Expressions 

package tools;

class PrettyPrint extends ExpressionVisitor 
{
  void visitIntExp(IntExp e) 
  { 
    System.out.print(e.value); 
  } 

  void visitAddExp(AddExp e) 
  { 
    e.e1.accept(this); 
    System.out.print(" + "); 
    e.e2.accept(this); 
  } 
}