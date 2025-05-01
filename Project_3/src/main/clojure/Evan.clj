(ns Evan)
(defn member [atm lizt]
  (loop [lst lizt]
    (cond 
      (empty? lst) false   ;; Uses (empty? lst) to check for an empty list
      (identical? atm (first lst)) true
      :else (recur (rest lst)))))  ;; Recurse with the rest of the list

(defn evanMap [fun lizt]
  (cond 
    (empty? lizt) '()  ;; Check if the list is empty and return an empty list
    (nil? (first lizt)) (recur fun (rest lizt))  ;; Skip null values
    :else (cons (fun (first lizt)) 
                (evanMap fun (rest lizt)))))  ;; Recur on the rest of the list

(defn intersect [lizt1 lizt2]
  (cond 
    (empty? lizt1) '()  ;; Uses (emptpy? lizt1) to check if lizt1 is empty
    (member (first lizt1) lizt2) ;; checks if the first element at lizt1 exists in lizt2
      (cons (first lizt1) (intersect (rest lizt1) lizt2)) ;; adds the element to the returned list and mooves to the next element in lizt1
    :else (intersect (rest lizt1) lizt2))) ;; ships the element and will recurse the rest of lizt1
