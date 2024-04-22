// start: sidebar
document.querySelectorAll('.sidebar-dropdown-toggle').forEach(function(item) {
    item.addEventListener('click', function (e) {
        console.log('misy click')
        e.preventDefault()
        const parent = item.closest('.group')
        if(parent.classList.contains('selected')) {
            parent.classList.remove('selected')
        } else {
            document.querySelectorAll('.sidebar-dropdown-toggle').forEach(function(i) {
                i.closest('.group').classList.remove('selected')
            })
            parent.classList.add('selected')
        }
    })
})

// end: sidebar