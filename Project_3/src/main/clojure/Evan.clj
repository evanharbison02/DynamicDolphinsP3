(ns Evan)
(defn member [atm lizt]
  (loop [lst lizt]
    (cond 
      (empty? lst) false   ;; Use (empty? lst) to check for an empty list
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
    (empty? lizt1) '()
    (member (first lizt1) lizt2)
      (cons (first lizt1) (intersect (rest lizt1) lizt2))
    :else (intersect (rest lizt1) lizt2)))
