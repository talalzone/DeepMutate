parser grammar DeepMutateParser;

options { tokenVocab = DeepMutateLexer; }

parse
    : (projectDecl)* EOF
    ;

projectDecl
    : FROM '(' inputConf ')' MUTATE '(' projectConf ')' OUTPUT '(' outputConf ')' '{' (functionDecl)* '}'
    ;

functionDecl
    : DEFINE functionId '{' (mutationDecl)* '}'
    ;

mutationDecl
    : ('[' mutationId ']')? ('[' mutationConf ']')? matchStmt (whereStmt)? (setStmt+ | insertStmt+)
    ;

matchStmt
    : MATCH ':'? '('? pattern ')'?
    ;

whereStmt
    : WHERE ':'? '('? pattern ')'?
    ;

setStmt
    : SET ':'? '('? pattern ')'?
    ;

insertStmt
    : INSERT ':'? '('? pattern ')'?
    ;

functionId
    : IDENTIFIER
    ;

mutationId
    : IDENTIFIER
    ;

pattern
    : STRING_LITERAL
    ;

inputConf
    : type=CONSOLE ('=' val=STRING_LITERAL)?                                                                # consoleInputConf
    | type=CODE     '=' (val=STRING_LITERAL | '[' list=strList ']')                                         # codeInputConf
    | type=FILE     '=' (val=STRING_LITERAL | '[' list=strList ']')                                         # fileInputConf
    | type=DIR      '=' (val=STRING_LITERAL | '[' list=strList ']') ',' (BUILD '=' build=STRING_LITERAL)    # dirInputConf
    ;

projectConf
    : conf (',' conf)*
    ;

outputConf
    : conf (',' conf)*
    ;

mutationConf
    : conf (',' conf)*
    ;

conf
    : key=(LANG | TYPE | ANALYZE) '=' val=STRING_LITERAL                                // ProjectConf
    | key=(DATASTORE | URI | DB | USER | PASS | REPORT) '=' val=STRING_LITERAL          // OutputConf
    | key=ACTIVE '=' val=STRING_LITERAL                                                 // MutationConf
    ;

strList
    : list+=STRING_LITERAL (',' list+=STRING_LITERAL)*
    ;
