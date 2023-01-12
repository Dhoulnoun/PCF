grammar PCF;

// règles syntaxiques

program : term EOF ;
term : LIT                                   # Lit
     | ID                                  # Id
     | '(' term ')'                          # Par
     | term OPHP term                        # BinOp
     | term OPLP term                        # BinOp
     | 'ifz' term 'then' term 'else' term    # Cond
     ;

// règles lexicales
OPHP : '*' | '/' ;
OPLP : '+' | '-';
LIT : '0' | [1-9][0-9]* ;
WS : [ \t\n\r]-> channel(HIDDEN) ;
LINE_COMMENT : '//' ~ '\n'* '\n' -> channel(HIDDEN) ;
ID : [a-zA-Z_]+ [a-zA-Z0-9_]* ;
