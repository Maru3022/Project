import React from 'react'


const books = [
    { id: 1, title: 'Война и мир', author: 'Л. Толстой' },
    { id: 2, title: 'Преступление и наказание', author: 'Ф. Достоевский' },
    { id: 3, title: 'Мастер и Маргарита', author: 'М. Булгаков' },
]


export default function BookCatalog() {
    return (
        <div>
            <div className="mb-6 flex items-center justify-between">
                <h3 className="text-2xl font-semibold">Каталог книг</h3>
            </div>


            <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
                {books.map(b => (
                    <div key={b.id} className="p-4 bg-white rounded shadow">
                        <h4 className="font-bold">{b.title}</h4>
                        <p className="text-sm text-gray-500">{b.author}</p>
                    </div>
                ))}
            </div>
        </div>
    )
}