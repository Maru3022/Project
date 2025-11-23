import React from 'react'


export default function Dashboard() {
    return (
        <div>
            <div className="grid grid-cols-3 gap-6">
                <div className="p-6 bg-white rounded-xl shadow">Панель 1</div>
                <div className="p-6 bg-white rounded-xl shadow">Панель 2</div>
                <div className="p-6 bg-white rounded-xl shadow">Панель 3</div>
            </div>


            <section className="mt-8">
                <h3 className="text-2xl font-semibold mb-4">Последние книги</h3>
                <div className="grid grid-cols-3 gap-4">
                    <div className="p-4 bg-white rounded shadow">Книга A</div>
                    <div className="p-4 bg-white rounded shadow">Книга B</div>
                    <div className="p-4 bg-white rounded shadow">Книга C</div>
                </div>
            </section>
        </div>
    )
}