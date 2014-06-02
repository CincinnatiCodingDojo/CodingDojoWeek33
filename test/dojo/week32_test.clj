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
