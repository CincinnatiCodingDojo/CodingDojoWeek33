(ns dojo.week32-test
  (:require [midje.sweet :refer :all]
            [dojo.week32 :refer :all]))

(fact "can read file"
  (count (read-file-into-seq)) => 172820)

(fact "can get list of 7 letter words"
  (count  (getwords 7)) => 23109)

(fact "get length of word"
  (length-of-word "prateek") => 7)

(fact "can get specified number of random words"
  (count (get-possible-passwords 10 (getwords 7))) => 10)

(fact "can return how many letters match guess"
  (compare-words "prateek" "prateek") => 7
  (compare-words "mind" "mend") => 3
  (compare-words "compute" "playful") => 0)

(facts "guess"
  (let [state {:words ["compute" "playful"] :count 0 :password "compute"}]
	(fact "can count number of tries"
	  (guess state "playful" ) => (contains {:count 1}))
	(fact "returns number of letter matches"
	  (guess state "playful" ) => (contains {:matches 0})
	  (guess state "compute" ) => (contains {:matches 7}))))

(facts "init-state"
	(let [wordlist ["a" "afd" "b" "c" "asd"]]
		(fact "generates an initial game state with count 0"
			(init-state wordlist 2 1) => (contains {:count 0}))
		#_(fact "generates a valid word list"
			(init-state wordlist 2 1) => (contains {:words ["a" "b"]}))
	)
) 

(fact "can filter possible passwords from given list"
	(let [wordlist ["abd" "bcd"]]
		(get-words-of-length wordlist 1 3) => ["abd"])
		(get-words-of-length wordlist 1 3) => ["abd"])
	
	)


