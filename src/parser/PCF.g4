grammar PCF;

// règles syntaxiques

program : term EOF ;
term : LIT                                   # Lit
     | term OP term                          # BinOp
     | 'ifz' term 'then' term 'else' term    # Cond
     ;

// règles lexicales

OP  : '+' | '-' | '*' | '/' ;
LIT : '0' | [1-9][0-9]* ;
