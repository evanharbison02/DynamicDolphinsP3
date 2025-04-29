(ns Alice)

(defn third [list]
	(first (rest (rest list)))
)

(defn member [atm lizt]]
	(cond 
		(nil? lizt) 
			false
		(identical? atm (first lizt))
			true
		:else (member atm (rest lizt) )
	
	)

)

(defn map [fun lizt]
	(cond 
		(nil? lizt)
			'()
		:else (cons fun (first lizt) 
			(map fun (rest lizt)))
	)
)

(defn memq [element lizt] ;;made for the intersect def might not need later 
	(lazy-seq
		(cond
			(nil? lizt)
				false
			(identical? (fist lizt) element)
				lizt
			:else (memq element (rest lizt))
		)
	)
)

(defn intersect [lizt1 lizt2]
	(cond 
		(nul? lizt1)
			'()
		(memq (first lizt1) lizt2)
			(cons (first lizt1) (intersect (rest lizt1) lizt2))
		:else (intersect (rest lizt1) lizt2)
	)
)

