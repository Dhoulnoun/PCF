grammar PCF;

// règles syntaxiques

//program : term EOF ;
term : LIT                                   # Lit
     | VAR                                   #VarUse
     | PARENG term PAREND                    # Par
     | term term                             # App
     | term OPHP term                        # BinOp
     | term OPLP term                        # BinOp
     | 'let' VAR '=' term 'in' term          # Var
     | IFZ term THEN term ELSE term          # Cond
     //| LET ID ASSIGN term IN term            # Let
     | FUN ID ARROW term                     # Fun
     // | ID                                    # Var
     ;

// règles lexicales
OPHP : '*' | '/' ;
OPLP : '+' | '-';
VAR : [a-zA-Z]+;
LIT : '0' | [1-9][0-9]* ;
WS : [ \t\n\r]-> channel(HIDDEN) ;
LINE_COMMENT : '//' ~ '\n'* '\n' -> channel(HIDDEN) ;
ID : [a-zA-Z_]+ [a-zA-Z0-9_]* ;
IFZ  : 'ifz';
THEN : 'then';
ELSE : 'else';
ARROW : '->';
FUN : 'fun';
ASSIGN : '=';
PARENG : '(';
PAREND : ')';
