# Tests qui ne passent pas:

- ifz 0 then 1 else 2 ==> 1
- ifz 1 then 1 else 2 ==> 2
- 4 / 0 ==> / by zero ?
- z ==> exception ?
- Vérification que la modification de l'environnement n'est pas destructrice : let x = (let y = 1 in y) in y ?

Les fonction incrémenter sont à 1 d'être bons
- let inc = fun x -> x + 1 in inc 1 ==> 2
- let add = fun x -> fun y -> x + y in let inc = add 1 in inc 2 ==> 3
- let inc = fun x -> x + 1 in 3 + inc 1 ==> 5

- 01 ==> exception


- (fun x -> x x) fun x -> x x?

- let fact = fix f fun n -> ifz n then 1 else n * f (n - 1) in fact 3?


- fix x x
