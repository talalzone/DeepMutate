# DeepMutate #

A Language/Platform agnostic Mutation & Analysis Language.

Useful for:

* Mutation Analysis
* Generating synthetic code data for DeepLearning models etc
* Analyzing interesting code points

## Setup ##
```   
    git clone https://github.com/talalzone/DeepMutate
``` 
``` 
    ./gradlew clean shadowJar
``` 

## Requirements ##
* Java 17+

## Quickstart ##

```
    from (dir='/path/to/java-project')
    mutate(lang='java', type='semantic', analyze='true')
    out(store='mongodb', report='html') {
        
        def mutators {
    
            [method_call_returns_int][active='true']
            match:  'int i = someNonVoidMethod();'
            set:    'int i = 0;'
    
            [method_call_returns_obj][active='true']
            match:  'Object o = someNonVoidMethod();'
            set:    'Object o = null;'
    
            [method_call_only][active='false']
            match:  'someVoidMethodCall()'
            set:    'NO_OP'
    
            [binaryop_switch][active='false']
            match:  'if (a == b)'
            set:    'if (a != b)'
        
        }

    }
```

To run sample.dm (containing above code)

```
    java -jar deep-mutate-<version>.jar --run sample.dm   
```

See all CLI commands:

```
    java -jar deep-mutate-<version>.jar --help
```

Reports are generated under directory:

```
    deep-mutate-report
```



## Specifications ##

### Project Declaration(s) ###

_DeepMutate_ consists of one or more _**Project Declarations**_.

A _**Project Declaration**_ consists of **FROM**, **MUTATE** and **OUTPUT** statements. 

This is followed by one or more **Mutation Functions** containing one or more **Mutation Statements (clauses**). 


#### <u>FROM STATEMENT</u> ####

Read from project directory(s):

```
    // Single project directory
    FROM (dir='/path/to/project-dir', build='gradle') 

    // Multiple project directories
    FROM (dir=['/path/to/project-1', '/path/to/project-2'], build_system='maven']
```

Read from code file(s):

```
    // Read single file
    FROM ( file='/path/to/ClassA.java' )
    
    // Read multiple files
    FROM ( files=['/path/to/ClassA.java', '/path/to/ClassB.java'] )'   
    
```


Read from inline code:

```
    FROM (code='ClassA { void someMethod() { /* some code etc */ } }'
```

Read from console:

```
    FROM (console)
```

>**NOTE:** _build_ or _build_system_ need to be set for mutation analysis (i.e., when analyze='true')

###### ATTRIBUTES SUMMARY ######

| Type                          | Values                                                                                   |
|-------------------------------|------------------------------------------------------------------------------------------|
| **DIR**                       | Dir path(s) e.g., 'java/project' or ['java/project-1', 'java/project-2']                 |
| **FILE**                      | File path(s) e.g., 'ClassA.java' or ['ClassA.java', 'ClassB.java']                       |
| **CODE**                      | Any syntactically correct code e.g., 'AnyClassA { void anyMethod() {/* method body */} } |
| **CONSOLE**                   | Read input from console                                                                  |
| **BUILD** or **BUILD_SYSTEM** | Build System to use. Available: _Maven_, _Gradle_                                        | 


#### <u>MUTATE STATEMENT</u> ####

```
    MUTATE (lang='java', type='semantic', analyze='true')
```

###### ATTRIBUTES SUMMARY ######
| Type                     | Values                    | Default    |
|--------------------------|---------------------------|------------|
| **LANG** or **LANGUAGE** | 'java', 'python' etc      | Not set    |
| **TYPE**                 | 'semantic' or 'syntactic' | 'semantic' |
| **ANALYZE**              | 'true' or 'false'         | 'false'    |


#### <u>OUTPUT STATEMENT</u> ####

Sending mutations out to a datastore (e.g., MongoDB):

```
    // Connects to default mongodb local instance
    OUT (store='mongodb', report='true')
    
    // Same statement but a bit verbose
    OUTPUT (datastore='mongodb', report='html')
```

###### ATTRIBUTES SUMMARY ######

| Type                       | Values                                   | Default      |
|----------------------------|------------------------------------------|--------------|
| **STORE** or **DATASTORE** | 'mongodb', 'arangodb', 'csv', 'cache'    | Not set      | 
| **URI**                    | 'mongodb://...', 'arangodb://'           | Not set      |
| **REPORT**                 | 'csv', 'console', html', 'true', 'false' | 'false'      |
| **DB** or **DATABASE**     | 'any_database_name'                      | 'deepmutate' |
| **COL** or **COLLECTION**  | 'any_collection_or_table_name'           | 'mutations'  |
| **ANALYZE**                | 'true' or 'false'                        | 'false'      |



#### <u>MUTATION FUNCTIONS</u> ####

Mutation functions groups together different mutator statements.

```
    def <some_mutation_function_identifier> {
    
        /*
            match:  '<pattern>'
            set:    '<update>'
            
            match:  '<pattern>'
            set:    '<update>'
        */
    }

    def <another_mutation_function_identifier> {
    
        /*
            match:  '<pattern>'
            where:  '<filter>'
            set:    '<update>'
            
            match:  '<pattern>'
            where:  '<filter>'
            set:    '<update>'
        */
    }
```

#### <u>MUTATION STATEMENTS</u> ####

A mutation statement consists of **MATCH**, **WHERE** and **SET** clauses.

``` 
    ['optional_mutation_identifier'][<optional configurations e.g., active='true'>]
    match:  'return x;' // Pattern in code to match
    
    // Any filter clause
    where:  'x is java.util.Optional'
    
    // Changes to be applied to the matched pattern
    set:    'return Optional.empty()'
```

**MATCH** should have a syntactically correct expression, conditional, declaration etc.

_DeepMutate_ checks for lexical type match in the sourcecode Abstract Syntax Tree (AST).
The 'match' context is replaced by the 'set' context in the AST.

The variable names are kept as is.





###### ATTRIBUTES SUMMARY ######
| Type           | Values                                 | Optional | Default        |
|----------------|----------------------------------------|----------|----------------|
| **IDENTIFIER** | 'any_string_identifier' without spaces | Yes      | auto-generated |
| **ACTIVE**     | 'true' or 'false'                      | Yes      | 'true'         |


### COMMENTS ###

Comments can appear any where in the DeepMutate code.

Inline comments:

```
    // This is an inline comments
```

Block comments:
```
    /*
         This is a block comment
    */
```

## Features ##

### Extensible Architecture ###
* Further languages can be added
* Support for Semantic & Syntactic mutations
* Support for Multi-model DBMS: SQL, NoSQL and Graph
* Generates mutations with several accessible data points:
  * Source code
  * Mutated code
  * Mutation patterns
  * Stack traces

### Languages ###
* Java
* **Future**: Python, Javascript, Golang etc

### Build Systems ###
* Gradle
* Maven

### Datastores ###
* MongoDB
* ArangoDB
* CSV

### Reports ###
* HTML
* CSV
* Console


## License ##
This project is licensed under the MIT License

