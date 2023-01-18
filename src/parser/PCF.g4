grammar PCF;

// règles syntaxiques

program : term EOF ;
term : LIT                                   # Lit
     | ID                                    # Var
     | '(' term ')'                          # Par
     | term term                             # App
     | term OPHP term                        # BinOp
     | term OPLP term                        # BinOp
     | IFZ term THEN term ELSE term    # Cond
     | 'let' ID '=' term 'in' term          # Let
     | 'fun' ID '->' term                   # Fun
     ;

// règles lexicales
OPHP : '*' | '/' ;
OPLP : '+' | '-';
LIT : '0' | [1-9][0-9]* ;
WS : [ \t\n\r]-> channel(HIDDEN) ;
LINE_COMMENT : '//' ~ '\n'* '\n' -> channel(HIDDEN) ;
ID : [a-zA-Z_]+ [a-zA-Z0-9_]* ;
IFZ  : 'ifz';
THEN : 'then';
ELSE : 'else';
