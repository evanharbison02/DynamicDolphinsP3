(ns Jess)
(defn append [lizt1 lizt2]
  (cond
    (empty? lizt1) lizt2 ;; checks if lizt1 is empty and retuns lizt2
    :else (cons (first lizt1) ;; takes the first elememt in lizt1  
      (append (rest lizt1) lizt2)))) ;; then the rest of lizt1 is recursivly appended to lizt2

(defn same [lizt1 lizt2]
  (cond
    (empty? lizt1) (empty? lizt2) ;; checks if either list is empty
    (empty? lizt2) false ;; will return false if only lizt2 is empty
    (= (first lizt1) (first lizt2)) ;; if both elements are the same then it will recurs to the next element in each list
      (same (rest lizt1) (rest lizt2))
	:else false)) ;; the first elements in each list are not equal then will return false
